package cm;

import javax.swing.*;
import java.awt.*;


/**
 * Created by kaval on 03.07.2017.
 */
public class Enemy {
    private int r,hp;
    private double dx,dy,x,y,v,radian;
    private boolean dead;
    private Image img1 = new ImageIcon("png/Enemy1.png").getImage();
    private Image img;

    public Enemy() {
        img = img1;
        v = 3;
        hp = 1;
        r = 7;
        x = Math.random() * Panel.width / 2 + Panel.height / 4;
        y = -r;
        double L = Math.toRadians(Math.random() * 140+20);
        radian = Math.toRadians(L);
        dx = Math.sin(radian) * v;
        dy = Math.cos(radian) * v;
        dead = false;
    }

    public void tick() {
        x += dx;
        y += dy;
        if (x < r && dx < 0) dx = -dx;
        if (x > Panel.width - r && dx > 0) dx = -dx;
        if (y < r && dy < 0) dy = -dy;
        if (y > Panel.height - r && dy > 0) dy = -dy;
    }

    public void draw(Graphics2D g) {
        g.drawImage(img, (int) (x - r), (int) (y - r), null);
    }

    public void hit() {
        hp--;
        if (hp <= 0) dead = true;
    }

    public boolean dead() {
        return dead;
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
