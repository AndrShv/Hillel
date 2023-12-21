// CalcController.java
package CalcOnMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController implements ActionListener {
    private CalcModel model;
    private CalcView view;

    public CalcController(CalcModel model) {
        this.model = model;
    }

    public void setView(CalcView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (Character.isDigit(actionCommand.charAt(0)) || actionCommand.equals(".")) {
            view.appendToTextField(actionCommand);
        } else {
            handleOperator(actionCommand);
        }
    }

    private void handleOperator(String operator) {
        if (!view.getText().isEmpty()) {
            int firstNum = Integer.parseInt(view.getText());
            model.setFirstNum(firstNum);
            model.setSign(operator);
            view.clearTextField();
        }
    }

    public void calculateResult() {
        if (!view.getText().isEmpty()) {
            int secondNum = Integer.parseInt(view.getText());
            int result = model.calculateResult(secondNum);
            view.setText(String.valueOf(result));
        }
    }
}
