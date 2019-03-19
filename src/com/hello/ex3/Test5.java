package com.hello.ex3;

public class Test5 {

    /* ---- x: 母鸡, y: 公鸡, z: 小鸡 ---- */


    /**
     * 第一种方法: (三层循环)
     *      从0-100遍历三种鸡
     */
    private static void method1() {
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                for (int z = 0; z <= 100; z++) {
                    if (isCorrect(x, y, z)) {
                        print(x, y, z);
                    }
                }
            }
        }
    }

    /**
     * 第二种方法: (两层循环)
     *      从0-100遍历两种鸡, 剩下那一种的数量即为剩下的鸡的数量
     */
    private static void method2() {
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                int z = 100 - x - y;
                if (isCorrect(x, y, z)) {
                    print(x, y, z);
                }
            }
        }
    }

    /**
     * 第三种方法: (一层循环)
     *      作为三元一次方程组, 解出y=f(x)以及z=f(x), 遍历x即可
     * 列方程得:
     *      x + y + z = 100
     *      5x + 3y + (1/3)z = 100
     * 解得:
     *      y = 25 - (7/4)x
     *      z = 75 + (3/4)x
     * 因y,z皆为非负整数, 可知x应为4的倍数, 且在[4, 12]范围内
     * 令x = 4 * n, 只需遍历n=0到n=3即可
     */
    private static void method3() {
        for (int n = 0; n <= 3; n++) {
            int x = 4 * n;
            int y = 25 - 7 * n;
            int z = 75 + 3 * n;

            // 因为已经过计算, 无需判断, 可直接输出
            print(x, y, z);
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        long startTime;

        // 测试第一种方法
        startTime = System.nanoTime();
        method1();
        System.out.println("第一种方法用时: " + (System.nanoTime() - startTime) + "ns");

        // 测试第二种方法
        startTime = System.nanoTime();
        method2();
        System.out.println("第二种方法用时: " + (System.nanoTime() - startTime) + "ns");

        // 测试第三种方法
        startTime = System.nanoTime();
        method3();
        System.out.println("第三种方法用时: " + (System.nanoTime() - startTime) + "ns");
    }

    // 判断输入方案是否符合要求
    private static boolean isCorrect(int x, int y, int z) {
        return x + y + z == 100
                && Math.abs(x * 5 + y * 3 + z * (1 / 3.0) - 100) < 0.000000001;
    }

    // 格式化输出母鸡公鸡与小鸡的数量
    private static void print(int x, int y, int z) {
        System.out.println(String.format("母鸡:%2d, 公鸡:%2d, 小鸡:%2d", x, y, z));
    }

}
