package com.hello.ex2;

import javax.swing.*;

public class TieredPricing {

    // 阶梯电价标准
    private final static double PRICE_1 = 0.55;
    private final static double TIER_2 = 240;
    private final static double PRICE_2 = 0.7;
    private final static double TIER_3 = 540;
    private final static double PRICE_3 = 0.95;

    public static void main(String[] args) {

        // 使用InputDialog获取输入 (没有异常处理, 输入必须为数字)
        double input = Double.valueOf(JOptionPane.showInputDialog(null,"请输入您的实际使用电量 (度) :"));

        // 使用If语句计算分层电价
        double output;
        if (input <= TIER_2) {
            output = input * PRICE_1;
        } else if (input <= TIER_3) {
            output = input * PRICE_1 + (input - TIER_2) * PRICE_2;
        } else {
            output = input * PRICE_1 + (input - TIER_2) * PRICE_2 + (input - TIER_3) * PRICE_3;
        }

        // 保留两位小数
        output = round2(output);

        // 使用MessageDialog显示输出
        JOptionPane.showMessageDialog(null, "您的电费为: " + output);
    }

    /**
     * 将输入四舍五入至两位小数并返回
     */
    private static double round2(double num) {
        return Math.round(num * 100) / 100.0;
    }
}
