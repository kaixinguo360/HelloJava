package com.hello.ex4.a.part1;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {


        /* 随机生成一个10个元素的随机整型数组 */

        int[] array = getArray(10, 0, 100);
        System.out.println("原始数组: " + Arrays.toString(array));


        /* 最大值, 最小值, 所有元素总和 */

        // 最大值与其在数组中的位置
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        // 最小值与其在数组中的位置
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        // 所有元素总和
        int sum = 0;

        // 索引 (一律从零开始)
        int index = 0;

        // 遍历所有元素
        for (int num : array) {

            // 找出最大值
            if (num > max) {
                max = num;
                maxIndex = index;
            }

            // 找出最小值
            if (num < min) {
                min = num;
                minIndex = index;
            }

            // 求和
            sum += num;

            index++;
        }
        System.out.println("最大值: " + max + ", 索引: " + maxIndex);
        System.out.println("最小值: " + min + ", 索引: " + minIndex);
        System.out.println("所有元素总和: " + sum);


        /* 冒泡排序 */
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序: " + Arrays.toString(array));
    }

    /**
     * 返回指定长度与范围的随机整型数组
     * @param length 数组的长度
     * @param min 数组内元素的最小值
     * @param max 数组内元素的最大值
     */
    public static int[] getArray(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random(max, min);
        }
        return array;
    }

    private static int random(int min, int max) {
        return (int) Math.round(min + Math.random() * (max - min));
    }
}
