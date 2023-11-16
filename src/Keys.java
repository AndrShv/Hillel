import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys {
    public static void main(String[] args){
    }
    Key key = new Key();
    public static class Key extends JFrame implements KeyListener{
        private int x = 50;
        private int y = 90;
        Key(){
            setSize(700, 500);
            setLayout(null);
            add(this);
            setVisible(true);
        }


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_RIGHT:
                    x+=10;
                    break;
                case KeyEvent.VK_LEFT:
                    x-=10;
                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keypressed = " + e.getKeyChar());
        }
    }
}