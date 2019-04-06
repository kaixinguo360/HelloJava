package com.hello.ex4.b;

public class Test1 {

    // @Test
    public static void main(String[] args) {

        // 测试长方形类
        Shape rectangle = new Rectangle(1, 2);
        rectangle.printArea();

        // 测试圆形类
        Shape circle = new Circle(1);
        circle.printArea();
    }
}

/**
 * 公共抽象父类
 */
abstract class Shape {
    abstract double area();
    abstract void printArea();
}

/**
 * 长方形类
 */
class Rectangle extends Shape {

    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    void printArea() {
        System.out.println("长方形面积为: " + area());
    }
}

/**
 * 圆形类
 */
class Circle extends Shape {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    void printArea() {
        System.out.println("圆形面积为: " + area());
    }
}
