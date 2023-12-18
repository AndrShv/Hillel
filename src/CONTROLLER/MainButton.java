package CONTROLLER;

import MODEL.ModelButton;
import VIEW.View;

public class MainButton {
    public static void main(String[] args) {
        ModelButton modelButton = new ModelButton();
        View view = new View();
        ControllerButton controllerButton = new ControllerButton(modelButton, view);
        view.setVisible(true);
    }
}


