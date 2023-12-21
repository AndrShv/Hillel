// CalcModel.java
package CalcOnMVC;

public class CalcModel {
    private int firstNum;
    private String sign;

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int calculateResult(int secondNum) {
        switch (sign) {
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "/":
                return firstNum / secondNum;
            case "*":
                return firstNum * secondNum;
            case "←":
                return firstNum / 10;
            default:
                throw new IllegalArgumentException("Invalid operation: " + sign);
        }
    }
}



