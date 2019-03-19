package com.hello.ex2;

import java.applet.Applet;
import java.awt.*;

public class MyFirstApplet extends Applet {

    public void paint(Graphics g) {

        // 设置文字颜色为蓝色
        g.setColor(Color.blue);

        // 于(0, 10)处输出指定文本
        g.drawString("这是一个Java Applet程序", 0, 10);

        //设置文字颜色为红色
        g.setColor(Color.red);

        //设置字体为(宋体, 加粗, 36号)
        g.setFont(new Font("宋体", Font.BOLD, 36));

        // 于(0, 100)处输出指定文本
        g.drawString("我改变了字体", 0, 100);
    }
}
