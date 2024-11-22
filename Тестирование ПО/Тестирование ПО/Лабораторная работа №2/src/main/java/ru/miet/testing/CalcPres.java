package main.java.ru.miet.testing;

import java.lang.ArithmeticException;

public final class CalcPres implements CalculatorPresenter {
    private final CalculatorView calcInstance;
    private final Calc calc;
    public CalcPres(CalculatorView calcInstance) {
        this.calcInstance = calcInstance;
        calc = new Calc();
    }
    @Override
    public void onPlusClicked() {
        double a=0,b=0;
        try {
            a = Double.parseDouble(calcInstance.getFirstArgumentAsString());
            b = Double.parseDouble(calcInstance.getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            calcInstance.displayError("Wrong number inputed");
            return;
        } catch(NullPointerException e) {
            calcInstance.displayError("Input a number");
            return;
        }
        calcInstance.printResult(calc.sum(a,b));
    }
    @Override
    public void onMinusClicked() {
        double a=0,b=0;
        try {
            a = Double.parseDouble(calcInstance.getFirstArgumentAsString());
            b = Double.parseDouble(calcInstance.getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            calcInstance.displayError("Wrong number inputed");
            return;
        } catch(NullPointerException e) {
            calcInstance.displayError("Input a number");
            return;
        }
        calcInstance.printResult(calc.subtract(a,b));
    }
    @Override
    public void onDivideClicked() {
        double a=0,b=0;
        try {
            a = Double.parseDouble(calcInstance.getFirstArgumentAsString());
            b = Double.parseDouble(calcInstance.getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            calcInstance.displayError("Wrong number inputed");
            return;
        } catch(NullPointerException e) {
            calcInstance.displayError("Input a number");
            return;
        }
        try {
            calcInstance.printResult(calc.divide(a,b));
        } catch(ArithmeticException e) {
            calcInstance.displayError("You can't divide by zero");
        } 
    }
    @Override
    public void onMultiplyClicked() {
        double a=0,b=0;
        try {
            a = Double.parseDouble(calcInstance.getFirstArgumentAsString());
            b = Double.parseDouble(calcInstance.getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            calcInstance.displayError("Wrong number inputed");
            return;
        } catch(NullPointerException e) {
            calcInstance.displayError("Input a number");
            return;
        }
        calcInstance.printResult(calc.multiply(a,b));
    }
}