package com.hello.ex4.b;

public class Test4 {

    // @Test
    public static void main(String[] args) {

        // 新建空数组
        // 并用随机创建的 IShapeArea 填充
        IShapeArea[] shapes = new IShapeArea[10];
        for (int i = 0; i < shapes.length; i++) {
            IShapeArea shape = null;
            switch ((int) (Math.random() * 2)) {
                case 0: {
                    int width = 1 +(int) (Math.random() * 9);
                    int height = 1 +(int) (Math.random() * 9);
                    shape = new Rectangle(width, height);
                    break;
                }
                case 1: {
                    int side = 1 + (int) (Math.random() * 9);
                    shape = new Square(side);
                    break;
                }
            }
            System.out.println(
                    "第" + i + "个形状: " + shape.toString() +
                    ", 面积: " + shape.getArea() +
                    ", 周长: " + shape.getPerimeter()
            );
            shapes[i] = shape;
        }

        // 计算面积与周长
        double sumArea = 0;
        double sumPerimeter = 0;
        for (IShapeArea shape : shapes) {
            sumArea += shape.getArea();
            sumPerimeter += shape.getPerimeter();
        }
        System.out.println("面积之和: " + sumArea);
        System.out.println("周长之和: " + sumPerimeter);
    }

    /**
     * 公共接口
     */
    interface IShapeArea {
        double getArea();
        double getPerimeter();
    }

    /**
     * 长方形类
     */
    static class Rectangle implements IShapeArea {

        /**
         * 设为 protected 权限, 便于子类读取
         */
        protected double width;
        protected double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        /**
         * 实现面积计算方法
         */
        @Override
        public double getArea() {
            return width * height;
        }

        /**
         * 实现边长计算方法
         */
        @Override
        public double getPerimeter() {
            return (width + height) * 2;
        }

        /**
         * 重写 toString() 方法, 便于输出为字符串
         */
        @Override
        public String toString() {
            return "长方形[ " + width + " x " + height + " ]";
        }
    }

    /**
     * 正方形类
     */
    static class Square extends Rectangle {

        /**
         * 直接调用父类的构造器, 将长与宽都设为边长
         * 继承父类的 getArea(), 与 getPerimeter()
         * 用来计算面积与周长
         */
        Square(double sideLength) {
            super(sideLength, sideLength);
        }

        /**
         * 重写 toString() 方法, 便于输出为字符串
         */
        @Override
        public String toString() {
            return "正方形[ " + width + " x " + height + " ]";
        }
    }
}