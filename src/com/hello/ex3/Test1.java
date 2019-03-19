package com.hello.ex3;

public class Test1 {

    public static void main(String[] args) {

        // 累加变量, 初始为零
        int sum = 0;

        // 从i=1开始遍历
        int i = 1;

        // 直到i=200
        while (i <= 200) {

            // 判断i是否为3的倍数
            if (i % 3 == 0) {

                // 如果是则累加到sum上
                sum += i;
            }

            // i递增
            i++;
        }

        // 输出最终累加结果
        System.out.println(sum);
    }
}
