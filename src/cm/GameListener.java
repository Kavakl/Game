package cm;

import java.awt.event.*;

/**
 * Created by kaval on 03.07.2017.
 */
public class GameListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) Player.up = true;
        if (key == KeyEvent.VK_DOWN) Player.down = true;
        if (key == KeyEvent.VK_RIGHT) Player.right = true;
        if (key == KeyEvent.VK_LEFT) Player.left = true;
        if (key == KeyEvent.VK_SPACE) Player.space = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) Player.up = false;
        if (key == KeyEvent.VK_DOWN) Player.down = false;
        if (key == KeyEvent.VK_RIGHT) Player.right = false;
        if (key == KeyEvent.VK_LEFT) Player.left = false;
        if (key == KeyEvent.VK_SPACE) Player.space = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
