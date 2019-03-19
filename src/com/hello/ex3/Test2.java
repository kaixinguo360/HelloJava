package com.hello.ex3;

public class Test2 {

    /**
     * 返回指定年份与月份下的天数
     * @param year 指定年份
     * @param month 指定月份
     * @return 指定年份与月份下的天数
     */
    public static int getDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
                        ? 29 : 28;
        }
        return 0;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {

        // 获取1998-2019每年每个月的天数
        for (int i = 1998; i <= 2019; i++){
            for (int j = 1; j <= 12; j++){
                System.out.println(String.format("%d-%02d: %d", i, j, getDays(i, j)));
            }
        }

        // 2月问题检验
        // 返回1000-2000年间所有"疑似"闰年的2月天数
        for (int i = 1000; i <= 2000; i+=4){
            System.out.println(String.format("%d-%02d: %d", i, 2, getDays(i, 2)));
        }
    }
}
