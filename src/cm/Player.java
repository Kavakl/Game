package cm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kaval on 03.07.2017.
 */
public class Player {
    private double x,y;
    private int r,v,hp;
    private Image img;
    private long timer,timer2;


    public static boolean up;
    public static boolean down;
    public static boolean right;
    public static boolean left;
    public static boolean space;


    public Player() {
        img = new ImageIcon("png/archer1.png").getImage();
        timer = System.nanoTime();
        timer2 = 200;
        x = Panel.width / 2;
        y = Panel.height / 2;
        hp = 5;
        r = 5;
        v = 5;
        up = false;
        down = false;
        right = false;
        left = false;
        space = false;
    }

    public void hit() {
        if (hp > 0) hp--;
        else {
            JOptionPane.showMessageDialog(null, "Press OK to be continue with 5 HP ");
            hp =5;
        }
    }

    public void tick() {
        if (up && y > r) y -= v;
        if (down && y < Panel.height - r) y += v;
        if (left && x > r) x -= v;
        if (right && x < Panel.width - r) x += v;
        if (space) {
            long a = (System.nanoTime() - timer) / 1000000;
            if (a > timer2) Panel.arrows.add(new Arrow());
            timer = System.nanoTime();
        }

    }

    public void draw(Graphics2D g) {
        g.drawImage(img, (int) (x - r), (int) (y - r), null);
        g.setColor(new Color(0, 100, 2));
        Font font = new Font("Arial", Font.ITALIC, 20);
        g.setFont(font);
        g.drawString("HP"+ " " + hp, 20, 30);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }
}
