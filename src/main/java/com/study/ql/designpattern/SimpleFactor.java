package com.study.ql.designpattern;

public class SimpleFactor {
    public static void main(String[] args) {
        Operator operator = Factory.createOperator("+");
        System.out.println(operator.action(4, 5));
    }
}


class Factory {
    public static Operator createOperator(String action) {
        Operator operator;
        switch (action) {
            case "+":
                operator = new AddOperator();
                break;
            case "-":
                operator = new DivOperator();
                break;
            default:
                operator = null;
        }
        return operator;
    }
}

interface Operator {
    int action(int a, int b);
}
class AddOperator implements Operator {

    @Override
    public int action(int a, int b) {
        return a + b;
    }
}
class DivOperator implements Operator {

    @Override
    public int action(int a, int b) {
        return a - b;
    }
}