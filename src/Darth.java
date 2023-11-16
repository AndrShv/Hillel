import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Darth extends JPanel {
    private BaseAnimation saltoAnimation;
    private BaseAnimation attackAnimation;
    private BaseAnimation standAnimation;
    private BaseAnimation currentAnimation;
    private BaseAnimation contrAnimation;

    Darth() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-10, -25, 66, 51));
        points.add(new Point(-58, -25, 66, 51));
        standAnimation = new BaseAnimation(points, true);
        currentAnimation = standAnimation;
        currentAnimation.start();
    }

    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return 82;
    }

    public void saltoAnim() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-15, -270, 65, 55));
        points.add(new Point(-75, -270, 65, 55));
        points.add(new Point(-135, -270, 65, 65));
        points.add(new Point(-180, -270, 65, 65));
        saltoAnimation = new BaseAnimation(points, false);
        saltoAnimation.start();
        currentAnimation = saltoAnimation;
    }

    public void contrAnim() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-10, -130, 65, 50));
        points.add(new Point(-55, -130, 65, 50));
        points.add(new Point(-110, -130, 65, 65));
        contrAnimation = new BaseAnimation(points, false);
        contrAnimation.start();
        currentAnimation = contrAnimation;
    }

    public void attackAnim() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-60, -1065, 80, 75));
        points.add(new Point(-115, -1065, 80, 75));
        points.add(new Point(-200, -1065, 80, 75));
        points.add(new Point(-290, -1065, 80, 75));
        attackAnimation = new BaseAnimation(points, false);
        attackAnimation.start();
        currentAnimation = attackAnimation;
    }

    public void standAnimation() {
        currentAnimation = standAnimation;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Vader.png"));
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
