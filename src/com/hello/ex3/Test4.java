package com.hello.ex3;

public class Test4 {

    public static void main(String[] args) {

        // 遍历XYZ
        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                for (int z = 0; z <= 9; z++) {

                    // 判断当前XYZ是否符合题目要求
                    if (isCorrect(x, y, z)) {

                        // 如果符合要求则输出当前XYZ的值
                        System.out.println(String.format("X=%d, Y=%d, Z=%d", x, y, z));
                    }
                }
            }
        }
    }

    /**
     * 判断输入XYZ是否符合题目要求
     */
    private static boolean isCorrect(int x, int y, int z) {
        return (x * 100 + y * 10 + z) + (y * 100 + z * 10 + z) == 532;
    }
}
