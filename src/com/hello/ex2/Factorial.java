package com.hello.ex2;

public class Factorial {

    public static void main(String[] args) {

        // 累加变量sum
        int sum = 0;

        // 调用factorial()方法
        // 依次计算1!, 2!, ..., 9!
        // 并累加至sum
        for (int i = 1; i <= 9; i++) {
            sum += factorial(i);
        }

        // 输出累加结果
        System.out.println(sum);
    }

    /**
     * 计算num!
     */
    private static int factorial(int num) {
        return num <= 0 ? 1 : num * factorial(num - 1);
    }
}
