package main;

import Scenes.Menu;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputHandler {
    
    public static int VERTICAL_AXIS = 0, HORIZONTAL_AXIS = 0, JUMP = 0;

    public void mousePressed(MouseEvent me){
        int button = me.getButton();
        
        switch (button) {
            case MouseEvent.BUTTON1:
                Menu.click();
                break;
            default:
                break;
        }
    }

    public void mouseReleased(MouseEvent me) {
        int button = me.getButton();
        
        switch (button) {
            case MouseEvent.BUTTON1:
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch (key) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_W:
                VERTICAL_AXIS = 1;
                break;
            case KeyEvent.VK_S:
                VERTICAL_AXIS = -1;
                break;
            case KeyEvent.VK_D:
                HORIZONTAL_AXIS = 1;
                break;
            case KeyEvent.VK_A:
                HORIZONTAL_AXIS = -1;
                break;
            case KeyEvent.VK_SPACE:
                JUMP = 1;
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch (key) {
            case KeyEvent.VK_W:
                VERTICAL_AXIS = 0;
                break;
            case KeyEvent.VK_S:
                VERTICAL_AXIS = 0;
                break;
            case KeyEvent.VK_D:
                HORIZONTAL_AXIS = 0;
                break;
            case KeyEvent.VK_A:
                HORIZONTAL_AXIS = 0;
                break;
            case KeyEvent.VK_SPACE:
                JUMP = 0;
                break;
            default:
                break;
        }
    }
    
}
