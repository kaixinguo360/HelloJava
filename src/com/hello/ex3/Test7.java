package com.hello.ex3;

public class Test7 {

    public static void main(String[] args) {

        // 打印出每个月
        for (int i = 1; i <= 24; i++) {
            
            // 总数 = 2 * 对数
            System.out.println(String.format("第%2d个月的兔子数: %d", i, 2 * getAll(i)));
        }
    }

    /**
     * 返回输入月份下的兔子总对数
     * 本月兔子总数 = 上月原始兔子数[getAll(month - 1)] + 本月出生的兔子数
     * 本月出生的兔子数 = 本月有生育能力的兔子数 = 两个月前的兔子总数[getAll(month - 2)]
     * @param month 经过的月份
     * @return 输入月份下的兔子总数
     */
    private static int getAll(int month) {
        // 若月份小于等于, 则没有新兔子出生, 兔子数一直为原始兔子数1
        return month <= 2 ?
                1 :
                // 第一个getAll为上个月的兔子总数
                getAll(month - 1)
                        // 第二个getAll为本月出生的兔子总数
                        + getAll(month - 2);
    }
}
