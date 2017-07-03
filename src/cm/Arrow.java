package cm;
import javax.swing.*;
import java.awt.*;

/**
 * Created by kaval on 03.07.2017.
 */
public class Arrow {
    private double x,y;
    private int r,v;
    Image img;

    public Arrow() {
        x = Panel.player.getX();
        y = Panel.player.getY();
        r = 5;
        v = 10;
        img = new ImageIcon("png/arrow.png").getImage();
    }

    public boolean remove() {
        if (y < 0) return true;
        else return false;
    }

    public void tick() {
        y -= v;
    }

    public void draw(Graphics2D g) {
        g.drawImage(img, (int) (x - r), (int) (y - r), null);
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
