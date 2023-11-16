import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SecCalc extends JFrame implements ActionListener {
    private JTextField text = new JTextField();
    private JButton eq = new JButton("=");
    private String sign;
    private int firstNum;
    SecCalc() {
        setSize(500, 500);
        setLayout(null);
        text.setBounds(50, 10, 400, 50);
        JButton b1 = new JButton("1");
        b1.setBounds(50, 60, 100, 100);
        JButton b2 = new JButton("2");
        b2.setBounds(50, 160, 100, 100);
        JButton b3 = new JButton("3");
        b3.setBounds(50, 260, 100, 100);
        JButton plus = new JButton("+");
        JButton b4 = new JButton("4");
        b4.setBounds(50, 360, 100, 100);
        JButton b5 = new JButton("5");
        b5.setBounds(150, 60, 100, 100);
        JButton b6 = new JButton("6");
        b6.setBounds(150, 160, 100, 100);
        JButton b7 = new JButton("7");
        b7.setBounds(150, 260, 100, 100);
        JButton b8 = new JButton("8");
        b8.setBounds(150, 360, 100, 100);
        JButton b0 = new JButton("0");
        b0.setBounds(250, 360, 100, 100);
        JButton b9 = new JButton("9");
        b9.setBounds(250, 260, 100, 100);
        plus.setBounds(250, 160, 100, 100);
        eq.setBounds(250, 60, 100, 100);
        add(text);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b0);
        add(plus);
        add(eq);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b0.addActionListener(this);
        b9.addActionListener(this);
        plus.addActionListener(this);
        eq.addActionListener(this);
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        switch (e.getActionCommand()) {
            case "1":
                text.setText(text.getText() + "1");
                break;
            case "2":
                text.setText(text.getText() + "2");
                break;
            case "3":
                text.setText(text.getText() + "3");
                break;
            case "4":
                text.setText(text.getText() + "4");
                break;
            case "5":
                text.setText(text.getText() + "5");
                break;
            case "6":
                text.setText(text.getText() + "6");
                break;
            case "7":
                text.setText(text.getText() + "7");
                break;
            case "8":
                text.setText(text.getText() + "8");
                break;
            case "9":
                text.setText(text.getText() + "9");
                break;
            case "0":
                text.setText(text.getText() + "0");
                break;
            case "+":
                if (text.getText() != "")
                    firstNum = Integer.valueOf(text.getText());
                sign = "+";
                text.setText("");
                break;
            case "=":
                int secondNum = Integer.valueOf(text.getText());
                switch (sign) {
                    case "+":
                        String result = String.valueOf(firstNum + secondNum);
                        text.setText(result);
                }
                break;
            default:
                System.out.println("error");
        }
    }
    public static void main(String[] args){
        SecCalc calc = new SecCalc();
    }
}