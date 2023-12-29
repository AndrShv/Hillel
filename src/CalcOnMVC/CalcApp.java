
package CalcOnMVC;

public class CalcApp {
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcController calcController = new CalcController(model);
        CalcView view = new CalcView(calcController);
        view.setVisible(true);
    }
}
