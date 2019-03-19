package com.hello.ex3;

public class Test3 {

    public static void main(String[] args) {

        // 遍历100-999
        for (int i = 100; i <= 999; i++){

            //判断是否为水仙花数
            if (isDaffodil(i)) {

                // 若为水仙花数则输出
                System.out.println(i);
            }
        }
    }

    /**
     * 判断输入数字是否为水仙花数
     */
    private static boolean isDaffodil(int num) {

        // 个位十位与百位都有才判断, 多了也不行
        if (num >= 100 && num <= 999) {

            // 提取出整数的个位十位与百位
            String str = num + "";
            int num1 = Integer.valueOf(str.substring(0, 1));
            int num2 = Integer.valueOf(str.substring(1, 2));
            int num3 = Integer.valueOf(str.substring(2, 3));

            // 判断各位立方和是否等于原数
            return pow3(num1) + pow3(num2) + pow3(num3) == num;
        } else {
            return false;
        }
    }

    /**
     * 返回输入整数的立方
     */
    private static int pow3(int num) {
        return num * num * num;
    }
}
