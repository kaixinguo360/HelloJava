package com.hello.ex3;

public class Test6 {

    public static void main(String[] args) {

        // 计时开始
        long startTime = System.currentTimeMillis();

        // (判断进度使用)
        double maxValue = (double) Integer.MAX_VALUE;

        // 从0到Integer.MAX_VALUE遍历所有整数, 依次判断是否符合假设
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            // 判断是否违反假设, 即满足isDivisible但除9余数不为零
            // 因为求余运算量较小, 根据短路原理把它放到前面
            if (i % 9 != 0 && isDivisible(i)) {

                // 如果发现不符合假设的数字, 则输出它并终止程序
                System.out.println("发现不符合假设的数字: " + i);
                return;
            }

            // 由于所需时间过长, 输出完成百分比以便判断验证进度
            // 会有一些性能损失, 但不会改变结果的数量级
            if (i % 10000000 == 0) {
                System.out.println(String.format("%s%%", round2(i / maxValue * 100)));
            }
        }

        // 验证完成, 输出结果
        System.out.println("全部非负整数 (0 - " + Integer.MAX_VALUE + ") 验证完成, 全部符合假设!");

        // 计时结束
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("用时: %sm", (endTime - startTime) / (1000.0 * 60)));
    }

    /**
     * 判断输入num各位之和是否能被9整除
     * @param num 要判断的int类型数字
     */
    private static boolean isDivisible(int num) {
        String str = "" + num;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.valueOf(str.substring(i, i + 1));
        }
        return sum % 9 == 0;
    }

    /**
     * 将输入四舍五入至两位小数并返回 (判断进度使用)
     */
    private static double round2(double num) {
        return Math.round(num * 100) / 100.0;
    }
}
