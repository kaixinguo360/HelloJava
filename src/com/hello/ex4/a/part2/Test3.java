package com.hello.ex4.a.part2;

public class Test3 {

    // @Test
    public static void main(String[] args) {
        // 两个数相加
        plus(1, 2);
        // 三个数相加
        plus(1, 2, 3);
        // 四(多)个数相加
        plus(1, 2, 3, 4);
        // 多个数相加
        plus(1, 2, 3, 4, 5);

        // 实验 //
        System.out.println("\n测试: '零个数相加'与'一个数相加'\n");

        // 零个数相加
        plus(1, 2, 3, 4, 5);
        // 一个数相加
        plus(1, 2, 3, 4, 5);
    }

    // 两个数相加
    private static double plus(double num1, double num2) {
        System.out.println("> '两个数相加'被调用!");
        return num1 + num2;
    }

    // 三个数相加
    private static double plus(double num1, double num2, double num3) {
        System.out.println("> '三个数相加'被调用!");
        return num1 + num2 + num3;
    }

    // 四个或以上数相加
    private static double plus(double... nums) {
        System.out.println("> '四个或以上数相加'被调用!");
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        return sum;
    }
}
