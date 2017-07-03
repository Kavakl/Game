package cm;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by kaval on 03.07.2017.
 */
public class Panel extends JPanel implements Runnable {
    private BufferedImage image;
    private boolean running;
    private Graphics2D g;
    private Thread thread;

    public static int width = 800;
    public static int height = 400;
    public static Player player;
    public static ArrayList<Arrow> arrows;
    public static ArrayList<Enemy> enemies;
    public static EnemyFactory enemyFactory;

    public Panel() {
        super();
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();

    }

    public void start() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        addKeyListener(new GameListener());
    }

    public void run() {
        running = true;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        player = new Player();
        arrows = new ArrayList<>();
        enemies = new ArrayList<>();
        enemyFactory = new EnemyFactory();

        while (running) {
            tick();
            render();
            paint();
            try {
                thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tick() {
        player.tick();
        enemyFactory.tick();
        for (int i = 0; i < arrows.size(); i++) {
            arrows.get(i).tick();
            boolean remove = arrows.get(i).remove();
            if (remove) {
                arrows.remove(i);
                i--;
            }
        }
        for (int i = 0; i < arrows.size(); i++) {
            Arrow a = arrows.get(i);
            double ax = a.getX();
            double ay = a.getY();
            double ar = a.getR();


            for (int j = 0; j < enemies.size(); j++) {
                Enemy e = enemies.get(j);
                double ex = e.getX();
                double ey = e.getY();
                double er = e.getR();
                double dx = ax - ex;
                double dy = ay - ey;
                double distans = Math.sqrt(dx * dx + dy * dy);

                if (distans < ar + er) {
                    e.hit();
                    arrows.remove(i);
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).dead()) {
                enemies.remove(i);
                i--;
            }
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).tick();
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();
            double er = e.getR();
            double pr = player.getR();
            double px = player.getX();
            double py = player.getY();
            double dx = ex - px;
            double dy = ey - py;
            double distans = Math.sqrt(dx * dx + dy * dy);
            if (distans <= er + pr) {
                e.hit();
                player.hit();
                for (int j = 0; j < enemies.size(); j++) {
                    if (enemies.get(j).dead()) {
                        enemies.remove(j);
                        j--;
                    }
                }
            }
        }
    }

    private void render() {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, width, height);
        player.draw(g);
        for (int i = 0; i < arrows.size(); i++) {
            arrows.get(i).draw(g);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g);
        }
        enemyFactory.draw(g);

    }

    private void paint() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}
