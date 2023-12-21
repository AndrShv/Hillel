// CalcView.java
package CalcOnMVC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcView extends JFrame implements ActionListener {
    private JTextField text = new JTextField();
    private CalcController controller;

    public CalcView(CalcController controller) {
        this.controller = controller;
        this.controller.setView(this);
        initializeUI();
    }

    private void initializeUI() {
        setSize(500, 500);
        setLayout(null);
        text.setBounds(50, 10, 400, 50);

        JButton b1 = new JButton("1");
        b1.setBounds(50, 60, 100, 100);
        JButton b2 = new JButton("2");
        b2.setBounds(150, 60, 100, 100);
        JButton b3 = new JButton("3");
        b3.setBounds(250, 60, 100, 100);

        JButton b4 = new JButton("4");
        b4.setBounds(50, 160, 100, 100);
        JButton b5 = new JButton("5");
        b5.setBounds(150, 160, 100, 100);
        JButton b6 = new JButton("6");
        b6.setBounds(250, 160, 100, 100);

        JButton b7 = new JButton("7");
        b7.setBounds(50, 260, 100, 100);
        JButton b8 = new JButton("8");
        b8.setBounds(150, 260, 100, 100);
        JButton b9 = new JButton("9");
        b9.setBounds(250, 260, 100, 100);

        JButton b0 = new JButton("0");
        b0.setBounds(150, 360, 100, 100);

        JButton plus = new JButton("+");
        plus.setBounds(350, 60, 100, 100);
        JButton minus = new JButton("-");
        minus.setBounds(350, 160, 100, 100);
        JButton multiply = new JButton("*");
        multiply.setBounds(350, 260, 100, 100);
        JButton divide = new JButton("/");
        divide.setBounds(350, 360, 100, 100);

        JButton eq = new JButton("=");
        eq.setBounds(250, 360, 100, 100);
        JButton b10 = new JButton("!");
        b10.setBounds(50, 360, 100, 100);

        JButton clearOne = new JButton("←"); // Button for clearing one digit
        clearOne.setBounds(250, 10, 50, 50);

        JButton clearAll = new JButton("C"); // Button for clearing the entire input
        clearAll.setBounds(300, 10, 50, 50);

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
        add(b10);
        add(plus);
        add(minus);
        add(multiply);
        add(divide);
        add(eq);
        add(clearOne);
        add(clearAll);

        b1.addActionListener(controller);
        b2.addActionListener(controller);
        b3.addActionListener(controller);
        b4.addActionListener(controller);
        b5.addActionListener(controller);
        b6.addActionListener(controller);
        b7.addActionListener(controller);
        b8.addActionListener(controller);
        b9.addActionListener(controller);
        b0.addActionListener(controller);
        b10.addActionListener(controller);
        plus.addActionListener(controller);
        minus.addActionListener(controller);
        multiply.addActionListener(controller);
        divide.addActionListener(controller);
        eq.addActionListener(e -> controller.calculateResult());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String newText) {
        text.setText(newText);
    }

    public void appendToTextField(String textToAppend) {
        text.setText(text.getText() + textToAppend);
    }

    public void clearTextField() {
        text.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // You can add any specific view-related actions here if needed
    }
}
