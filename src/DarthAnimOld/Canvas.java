package DarthAnimOld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JFrame implements KeyListener {
    //тут
    private Darth darth = new Darth();

    Canvas() {
        setSize(700, 500);
        setLayout(null);
        addKeyListener(this);
        setVisible(true);
        darth.setBounds(50, 50, darth.getWidth(), darth.getHeight());
        add(darth);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int moveDistance = 10;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                darth.setLocation(darth.getX(), darth.getY() - moveDistance);
                break;
            case KeyEvent.VK_DOWN:
                darth.setLocation(darth.getX(), darth.getY() + moveDistance);
                break;
            case KeyEvent.VK_RIGHT:
                darth.setLocation(darth.getX() + moveDistance, darth.getY());
                break;
            case KeyEvent.VK_LEFT:
                darth.setLocation(darth.getX() - moveDistance, darth.getY());
                break;
            case KeyEvent.VK_NUMPAD1:
                new Thread(() -> darth.attackAnim()).start();
                break;
            case KeyEvent.VK_NUMPAD2:
                new Thread(() -> darth.contrAnim()).start();
                break;
            case KeyEvent.VK_ESCAPE:
                EndGameWindow endGameWindow = new EndGameWindow(50);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("keyReleased = " + keyEvent.getKeyChar());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Canvas canvas = new Canvas();
            canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
