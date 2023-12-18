package MODEL;
public class ModelButton {
    private String txt;

    public ModelButton() {
        txt = "Начальный текст";
    }

    public String getTxt() {
        return txt;
    }

    public void updateButtonText() {
        txt =  "Новый текст: " + txt.toUpperCase();
    }
}

