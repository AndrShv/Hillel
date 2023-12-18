package CONTROLLER;
import MODEL.ModelButton;
import VIEW.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerButton {
    private ModelButton modelButton;
    private View view;

    public ControllerButton(ModelButton modelButton, View view) {
        this.modelButton = modelButton;
        this.view = view;
        view.addButtonListener(new ButtonClickListener());
    }

    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelButton.updateButtonText();
            String newText = modelButton.getTxt();
            view.updateButtonText(newText);
        }
    }
}
