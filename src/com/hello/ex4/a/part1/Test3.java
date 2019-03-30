package com.hello.ex4.a.part1;

public class Test3 {

    public static void main(String[] args) {

        // 原始字符串
        String name = "My name is NetworkCrazy";

        // 指定字符串操作
        System.out.println("原始字符串: " + name);
        System.out.println("字符串长度为: " + name.length());
        System.out.println("字符串第一个字符: " + name.charAt(0));
        System.out.println("字符串最后一个字符: " + name.charAt(name.length() - 1));
        System.out.println("子字符串NetworkCrazy: " + name.substring(11));
        System.out.println("字符'e'最后一次出现的位置: " + name.lastIndexOf('e'));
    }
}
