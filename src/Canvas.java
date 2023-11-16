import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Canvas extends JFrame implements KeyListener {

    private int hp = 50;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private int x = 50;
    private int y = 50;
    private Darth darth = new Darth();
    private Monster monster = new Monster();
    Canvas() {
        setSize(700, 500);
        setLayout(null);
        addKeyListener(this);
        setVisible(true);
        darth.setBounds(x, y, darth.getWidth(), darth.getHeight());
        add(darth);
        monster.setBounds(x + 100, y, getWidth(), getHeight());
        add(monster);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int moveDistance = 10; // Adjust the move distance as needed
        switch (keyEvent.getKeyCode()) {
            // Handle movement for Darth
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
            // Handle movement for the Monster
            case KeyEvent.VK_W:
                monster.setLocation(monster.getX(), monster.getY() - moveDistance);
                break;
            case KeyEvent.VK_S:
                monster.setLocation(monster.getX(), monster.getY() + moveDistance);
                break;
            case KeyEvent.VK_D:
                monster.setLocation(monster.getX() + moveDistance, monster.getY());
                break;
            case KeyEvent.VK_A:
                monster.setLocation(monster.getX() - moveDistance, monster.getY());
                break;
            case KeyEvent.VK_NUMPAD6:
                darth.attackAnim();
                break;
            case KeyEvent.VK_NUMPAD4:
                darth.saltoAnim();
                break;
            case KeyEvent.VK_NUMPAD8:
                darth.contrAnim();
                break;
            case KeyEvent.VK_ESCAPE:
                EndGameWindow endGameWindow = new EndGameWindow(hp);
                break;
            case KeyEvent.VK_E:
                monster.runAnimation();
                repaint();
                break;
            case KeyEvent.VK_F:
                monster.attackAnimMonst();
                repaint();
                break;

        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("keyReleased = " + keyEvent.getKeyChar());
    }

}