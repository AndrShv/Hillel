import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Monster extends JPanel {
    private BaseAnimation attackAnimationMonst;
    private BaseAnimation standAnimation;
    private BaseAnimation currentAnimation;
    private BaseAnimation runAnimation;

    Monster() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-20, -15, 70, 70));
        points.add(new Point(-90, -15, 70, 70));
        standAnimation = new BaseAnimation(points, true);
        currentAnimation = standAnimation;
        currentAnimation.start();
    }

    @Override
    public int getWidth() {
        return 70;
    }

    @Override
    public int getHeight() {
        return 70;
    }

    public void attackAnimMonst() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-20, -220, 70, 70));
        points.add(new Point(-110, -220, 70, 70));
        points.add(new Point(-240, -220, 70, 70));
        points.add(new Point(-320, -220, 70, 70));
        attackAnimationMonst = new BaseAnimation(points, false);
        attackAnimationMonst.start();
        currentAnimation = attackAnimationMonst;
    }

    public void runAnimation() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-25, -80, 70, 70));
        points.add(new Point(-105, -80, 70, 70));
        points.add(new Point(-185, -80, 70, 70));
        points.add(new Point(-265, -80, 70, 70));
        points.add(new Point(-345, -80, 70, 70));
        points.add(new Point(-425, -80, 70, 70));
        runAnimation = new BaseAnimation(points, false);
        runAnimation.start();
        currentAnimation = runAnimation;
    }

    public void standAnimation() {
        currentAnimation = standAnimation;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("AngryMonster.png"));
            setSize(currentAnimation.getW(), currentAnimation.getH());
            g.drawImage(image, currentAnimation.getX(), currentAnimation.getY(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class BaseAnimation extends Thread {
        private int x;
        private int y;
        private int w;
        private int h;
        private boolean isAllTime;
        private ArrayList<Point> points;

        public BaseAnimation(ArrayList<Point> points) {
            this.points = points;
            this.isAllTime = true;
        }

        public BaseAnimation(ArrayList<Point> points, boolean isAllTime) {
            this.points = points;
            this.isAllTime = isAllTime;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                if (i == points.size()) {
                    i = 0;
                    if (!isAllTime) {
                        standAnimation();
                        return;
                    }
                }
                x = points.get(i).getX();
                y = points.get(i).getY();
                h = points.get(i).getH();
                w = points.get(i).getW();
                try {
                    Thread.sleep(1000 / 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                repaint();
                i++;
            }
        }

        public int getW() {
            return w;
        }

        public int getH() {
            return h;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
