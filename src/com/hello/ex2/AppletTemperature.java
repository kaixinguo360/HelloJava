package com.hello.ex2;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppletTemperature extends Applet implements ActionListener {

    // 摄氏度输入框
    private TextField temp1;

    // 华氏度输入框
    private TextField temp2;

    @Override
    public void init() {

        // 新建标签与输入框
        Label label1 = new Label("摄氏度: ");
        Label label2 = new Label("华氏度: ");
        temp1 = new TextField(10);
        temp2 = new TextField(10);

        // 添加标签与输入框到窗体
        add(label1);
        add(temp1);
        add(label2);
        add(temp2);

        // 为输入框添加接口回调对象ActionListener(this), 监听输入事件
        temp1.addActionListener(this);
        temp2.addActionListener(this);
    }

    /**
     * 实现ActionListener接口以监听输入事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if ("".equals(temp1.getText())) {
            double fah = Double.valueOf(temp2.getText());
            double cel = round2((fah - 32 ) /1.8);
            temp1.setText(cel + "℃");
        } else {
            double cel = Double.valueOf(temp1.getText());
            double fah = round2(1.8 * cel + 32);
            temp2.setText(fah + "℉");
        }
    }

    /**
     * 将输入四舍五入至两位小数并返回
     */
    private static double round2(double num) {
        return Math.round(num * 100) / 100.0;
    }
}
