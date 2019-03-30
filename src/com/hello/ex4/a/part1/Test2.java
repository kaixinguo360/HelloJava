package com.hello.ex4.a.part1;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {

        // 随机生成一个10个元素的随机整型数组
        int[] src = Test1.getArray(10, 0, 100);
        showArray("原始数组", src);

        // System.arraycopy()
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        showArray("复制数组", dest);

        // Arrays.copyOf()
        int[] copy = Arrays.copyOf(src, src.length);
        showArray("复制数组", copy);
    }

    /**
     * 使用foreach显示输入整型数组元素的内容
     * @param title 标题
     * @param array 输入整型数组
     */
    private static void showArray(String title, int[] array) {
        System.out.print(title + ": ");
        if (array != null) {
            if (array.length != 0) {
                int index = 0;

                // 用来判断是否为最后一个元素
                int maxIndex = array.length - 1;

                // 以左括号开头
                System.out.print("[");

                // foreach遍历数组
                for (int num : array) {

                    // 输出遍历到的元素
                    System.out.print(num);

                    // 判断是否为最后一个元素
                    if (index != maxIndex) {
                        // 以逗号分隔各元素
                        System.out.print(", ");
                    } else {
                        // 为最后一个元素时, 以右括号结尾
                        System.out.println("]");
                    }
                    index++;
                }
            } else  {

                // 数组为空时的输出
                System.out.println("[]");
            }
        } else {

            // 数组为null时的输出
            System.out.println("null");
        }
    }
}
