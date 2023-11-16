import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIthird extends JFrame implements ActionListener {
    private JButton b = new JButton("1");
    private JButton startButton = new JButton("Старт");
    private JButton stopButton = new JButton("Стоп");
    private JButton resetButton = new JButton("Скинути");
    private JLabel timerLabel = new JLabel("0 секунд");
    private boolean isEnable = false;
    private boolean isRunning = false;
    private int elapsedTime = 0;
    private Thread timerThread;

    public UIthird() {
        setSize(500, 500);
        setLayout(null);

        b.setBounds(50, 50, 100, 100);
        JButton b1 = new JButton("Ок");
        b1.setBounds(160, 50, 100, 100);
        b1.addActionListener(this);

        startButton.setBounds(50, 200, 80, 40);
        startButton.addActionListener(this);
        stopButton.setBounds(150, 200, 80, 40);
        stopButton.addActionListener(this);
        resetButton.setBounds(250, 200, 80, 40);
        resetButton.addActionListener(this);
        timerLabel.setBounds(50, 300, 200, 40);
        add(b);
        add(b1);
        add(startButton);
        add(stopButton);
        add(resetButton);
        add(timerLabel);
        setVisible(true);
        add(b);
        add(b1);
        add(startButton);
        add(stopButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == b) {
            hardTask();
            if (isEnable) {
                b.setForeground(Color.GREEN);
                isEnable = false;
            } else {
                b.setForeground(Color.RED);
                isEnable = true;
            }
        } else if (actionEvent.getSource() == startButton) {
            if (!isRunning) {
                isRunning = true;
                timerThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (isRunning) {
                            try {
                                Thread.sleep(1000);
                                elapsedTime++;
                                updateTimerLabel();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                timerThread.start();
            }
        } else if (actionEvent.getSource() == stopButton) {
            isRunning = false;
            if (timerThread != null) {
                timerThread.interrupt();
            }
        }

        try {
            timerThread.interrupt();
        }catch (NullPointerException e){
            System.out.println("Error");

        }

    }

    private void hardTask() {
       // Hard hard = new Hard();
       // hard.start();
    }




    private void updateTimerLabel() {
        SwingUtilities.invokeLater(new Runnable() {


            @Override
            public void run() {
                int seconds = elapsedTime % 60;
                int minutes = (elapsedTime / 60) % 60;
                int hours = elapsedTime / 3600;
                String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timerLabel.setText(time + " секунд");
            }
        });
    }



    public static void main(String[] args) {
        UIthird UIThird = new UIthird();
    }
}