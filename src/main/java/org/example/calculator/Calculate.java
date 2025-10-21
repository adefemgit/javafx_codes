package org.example.calculator;

public class Calculate {
    private double num1;
    private String Operator;

    public void setOperator(String Operator){
        this.Operator = Operator;
    }

    public void setNum1(double num1){
        this.num1 = num1;
    }

    public double Calc(double num2) {
        return switch (Operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> num2;

        };



    }
    public void clear() {
        num1 = 0;
        Operator = "";
    }

}
