package com.hello.ex4.a.part1;

public class Test4 {

    public static void main(String[] args) {

        // 原始字符串
        StringBuffer buffer = new StringBuffer("Happy new year!");
        System.out.println("原始字符串: " + buffer);

        // setCharAt
        buffer.setCharAt(0, 'h');
        System.out.println("setCharAt: " + buffer);

        // charAt
        System.out.println("charAt(14): " + buffer.charAt(14));

        // insert
        buffer.insert(14, ' ');
        buffer.insert(15, "2019");
        System.out.println("insert: " + buffer);

        // append
        buffer.append(" ＼(￣▽￣)／");
        System.out.println("append: " + buffer);
    }
}
