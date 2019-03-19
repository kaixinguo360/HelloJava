package com.hello.ex2;

public class Prime {

    public static void main(String[] args) {

        // 遍历1-200
        for (int i = 1; i <= 200; i++) {

            // 若i为质数则输出
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 检查输入整数是否为质数
     */
    private static boolean isPrime(int num) {
        if (num <= 0) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
