package VIEW;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JButton jButton;
    public View(){
        setTitle("Button");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jButton = new JButton("Button");
        add(jButton);
    }
    public void addButtonListener(ActionListener listener){
        jButton.addActionListener(listener);
    }

    public void updateButtonText(String txt) {
        jButton.setText(txt);
    }
}
