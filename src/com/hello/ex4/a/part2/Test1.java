package com.hello.ex4.a.part2;

public class Test1 {

    public static void main(String[] args) {

        // 设置长宽
        double width = 1;
        double height = 2;

        // 输出长宽
        System.out.println(String.format("长x宽 = %.1fx%.1f", width, height));

        // 以指定长宽创建Rectangle对象
        Rectangle rectangle = new Rectangle(1, 2);

        // 输出面积与边长
        System.out.println("面积 = " + rectangle.getArea());
        System.out.println("边长 = " + rectangle.getPerimeter());
    }
}

class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 获取周长
     */
    public double getPerimeter() {
        return (width + height) * 2;
    }

    /**
     * 获取面积
     */
    public double getArea() {
        return width * height;
    }
}