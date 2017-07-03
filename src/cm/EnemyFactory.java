package cm;

import java.awt.*;

/**
 * Created by kaval on 03.07.2017.
 */
public class EnemyFactory {
    private long timer,timer2,ping;

    public EnemyFactory() {
        timer = 0;
        ping = 0;
        timer2 = 0;
    }

    public void spawnEnemies() {
        int enemy = 4;
        while (enemy > 0) {
            Panel.enemies.add(new Enemy());
            enemy -= 1;
        }
    }

    public void tick() {
        if (Panel.enemies.size() == 0 && timer == 0) {
            timer = System.nanoTime();

        }
        if (timer > 0) {
            timer2 += (System.nanoTime() - timer) / 1000000;
            timer = System.nanoTime();
        }
        if (timer2 > ping) {
            spawnEnemies();
            timer = 0;
            timer2 = 0;
        }
    }

    public void draw(Graphics2D g) {}
}
