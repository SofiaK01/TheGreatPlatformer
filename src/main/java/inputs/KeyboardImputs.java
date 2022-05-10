package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardImputs implements KeyListener {
    public KeyboardImputs() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W :
                System.out.println("UP");
                break;
            case KeyEvent.VK_UP:
                System.out.println("UP");
                break;
            case KeyEvent.VK_S:
                System.out.println("DOWN");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
