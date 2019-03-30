package com.hello.ex4.a.part2;

public class Test2 {

    // @Test
    public static void main(String[] args) {

        // 三角形类测试
        double s1 = 1;
        double s2 = 2;
        double s3 = 2;
        Triangle triangle = new Triangle(s1, s2, s3);
        System.out.println(
                String.format(
                        "三角形\n----------\n" +
                                "> 三边长 = %.1f, %.1f, %.1f\n" +
                                "> 面积 = %.4f\n" +
                                "> 边长 = %.4f\n"
                        , s1, s2, s3,
                        triangle.getArea(),
                        triangle.getPerimeter()
                )
        );

        // 圆类测试
        double radius = 1;
        Circle circle = new Circle(radius);
        System.out.println(
                String.format(
                        "圆形\n----------\n" +
                                "> 半径 = %.1f\n" +
                                "> 面积 = %.4f\n" +
                                "> 边长 = %.4f\n"
                        , radius,
                        circle.getArea(),
                        circle.getPerimeter()
                )
        );

        // 梯形类测试
        double upperLine = 1;
        double lowerLine = 2;
        double height = 1;
        Ladder ladder = new Ladder(upperLine, lowerLine, height);
        System.out.println(
                String.format(
                        "梯形\n----------\n" +
                                "> 上底 = %.1f\n" +
                                "> 下底 = %.1f\n" +
                                "> 高 = %.1f\n" +
                                "> 面积 = %.4f\n"
                        , upperLine, lowerLine, height,
                        ladder.getArea()
                )
        );
    }
}

// 抽象父类 //

/**
 * 三种图形的抽象类
 * 预设了 perimeter(边长), area(面积) 两个变量, 并提供了对应的Getter
 * 子类只需在抽象方法 update() 中实现边长与面积的计算, 并在设置参数时调用即可
 */
abstract class Shape {

    // 边长与面积
    protected double perimeter;
    protected double area;

    /**
     * 根据新的参数更新边长与面积
     */
    protected abstract void update();

    /**
     * 获取周长
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * 获取面积
     */
    public double getArea() {
        return area;
    }
}

// 实现类 //

/**
 * 三角形类
 * 新增变量:
 *      isTriangle - 是否能组成三角形的标志
 * 新增方法:
 *      setSides(...) - 设置三边长
 *      isTriangle() - 判断是否能构成三角形
 */
class Triangle extends Shape {

    // 三边长
    private double side1;
    private double side2;
    private double side3;

    // 是否可以构成三角形
    private boolean isTriangle;

    public Triangle(double side1, double side2, double side3) {
        setSides(side1, side2, side3);
    }

    /**
     * 设置三边长
     */
    public void setSides(double side1, double side2, double side3) {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        // 调用update方法更新边长与面积
        update();
    }

    /**
     * 判断是否能构成三角形
     */
    public boolean isTriangle() {
        return isTriangle;
    }

    /**
     * 计算边长与面积
     */
    @Override
    protected void update() {

        // 判断是否能够组成三角形
        isTriangle = side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1;

        // 如果能组成三角形, 则计算边长与面积
        if (isTriangle) {
            // 计算边长
            perimeter = side1 + side2 + side3;
            // 计算面积 (海伦公式)
            area = Math.sqrt(perimeter * (perimeter-side1)* (perimeter-side2) * (perimeter-side3));
        } else {
            perimeter = 0;
            area = 0;
        }
    }
}

/**
 * 圆类
 * 新增变量:
 *      radius - 半径
 * 新增方法:
 *      setRadius(...) - 设置半径
 */
class Circle extends Shape {

    // 半径
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    /**
     * 设置半径
     */
    public void setRadius(double radius) {
        this.radius = radius;
        update();
    }

    /**
     * 计算周长与面积
     */
    @Override
    protected void update() {
        // 计算周长
        perimeter = 2 * Math.PI * radius;
        // 计算面积
        area = Math.PI * radius * radius;
    }
}

/**
 * 梯形类
 * 新增变量:
 *      upperLine - 上底
 *      lowerLine - 下底
 *      height - 高
 * 未实现的功能:
 *      周长计算 - 参数不充分
 */
class Ladder extends Shape {

    // 上底
    private double upperLine;

    // 下底
    private double lowerLine;

    // 高
    private double height;

    public Ladder(double upperLine, double lowerLine, double height) {
        this.upperLine = upperLine;
        this.lowerLine = lowerLine;
        this.height = height;
        update();
    }

    /**
     * 计算面积 (不计算周长)
     */
    @Override
    protected void update() {
        // 计算面积
        area = (upperLine + lowerLine) * height * 0.5;
    }
}