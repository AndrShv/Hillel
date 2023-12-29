package DarthAnimOld;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Darth extends JPanel {
    private BaseAnimation attackAnimation;
    private BaseAnimation standAnimation;
    private BaseAnimation currentAnimation;
    private BaseAnimation contrAnimation;


    Darth() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-10, -640, 65, 50));
        points.add(new Point(-60, -640, 65, 50));
        standAnimation = new BaseAnimation(points, true);
        currentAnimation = standAnimation;
        currentAnimation.start();
    }

    @Override
    public int getWidth() {
        return 35;
    }

    @Override
    public int getHeight() {
        return 50;
    }



    public void contrAnim() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-5, -275, 60, 50));
        points.add(new Point(-55, -275, 60, 50));
        points.add(new Point(-110, -275, 60, 50));
        points.add(new Point(-145, -275, 60, 50));
        points.add(new Point(-180, -275, 60, 50));
        contrAnimation = new BaseAnimation(points, false);
        contrAnimation.start();
        currentAnimation = contrAnimation;
    }
//тут
    public void attackAnim() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-5, -1010, 60, 50));
        points.add(new Point(-55, -1010, 60, 50));
        points.add(new Point(-110, -1010, 60, 50));
        points.add(new Point(-145, -1010, 60, 50));
        points.add(new Point(-180, -1010, 60, 50));
        points.add(new Point(-230, -1010, 60, 50));
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
            image = ImageIO.read(new File("DarthBlue.jpg"));
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
                        SwingUtilities.invokeLater(() -> standAnimation());
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

                SwingUtilities.invokeLater(() -> repaint());
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
