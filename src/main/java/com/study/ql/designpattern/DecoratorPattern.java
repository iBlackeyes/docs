package com.study.ql.designpattern;

/**
 * 装饰器类与被装饰器类共同实现同一个接口，这样就可以无限套娃
 * be care of Decorator is a abstract class.
 *
 * If only one ConcreteComponent class, DecoratorClass can extends it.
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        SimpleCoffee coffee = new SimpleCoffee();
        MilkDecorator milkCoffee = new MilkDecorator(coffee);
        SugerDecorator sugerMilkCoffee = new SugerDecorator(milkCoffee);
        System.out.println(sugerMilkCoffee.getCost());
        System.out.println(sugerMilkCoffee.getInternal());
    }
}

interface Coffee {
    double getCost();
    String getInternal();
}

class SimpleCoffee implements Coffee {

    @Override
    public double getCost() { return 1.0; }

    @Override
    public String getInternal() { return "coffee bean"; }
}

abstract class Decorator implements Coffee {
    Coffee coffee;
    Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getInternal() {
        return coffee.getInternal();
    }
}

class MilkDecorator extends Decorator {
    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getInternal() {
        return super.getInternal() + " milk";
    }
}

class SugerDecorator extends Decorator {
    SugerDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.3;
    }

    @Override
    public String getInternal() {
        return super.getInternal() + " suger";
    }
}

