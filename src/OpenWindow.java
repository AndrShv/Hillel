import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Model {

}

class View extends JFrame {
    private JButton button;

    public View() {
        button = new JButton("Нажми меня");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.onButtonClicked();
            }
        });

        JPanel panel = new JPanel();
        panel.add(button);

        add(panel);
        setTitle("Пример MVC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateView(String text) {

    }
}

class Controller {
    private static Model model = new Model();
    private static View view = new View();


    public static void onButtonClicked() {
        JOptionPane.showMessageDialog(view, "Привет, это всплывающее окно!");

    }
}

public class OpenWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Запуск приложения
                Controller.onButtonClicked();
            }
        });
    }
}
