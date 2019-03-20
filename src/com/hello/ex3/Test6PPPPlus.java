package com.hello.ex3;

public class Test6PPPPlus {

    public static void main(String[] args) throws Exception {

        // 计时开始
        long startTime = System.currentTimeMillis();

        // 当前要判断的数字
        int num = 0;

        // 个位为0的当前数字
        // 在第9层循环每次累加10
        // num = numBase + nums[0]
        int numBase = 0;

        // 替代nums[]
        int nums0;
        int nums1;
        int nums2;
        int nums3;
        int nums4;
        int nums5;
        int nums6;
        int nums7;
        int nums8;
        int nums9;

        // 多个cache变量
        int caches1;
        int caches2;
        int caches3;
        int caches4;
        int caches5;
        int caches6;
        int caches7;
        int caches8;

        // 计算次数计数
        int count = 0;

        // 从0到9依次遍历nums[]数组的每一位
        // 最内层循环顺带递增num
        outer:
        for (nums9 = 0; nums9 <= 9; nums9++) {
            for (nums8 = 0; nums8 <= 9; nums8++) {
                caches8 = nums9 + nums8;
                for (nums7 = 0; nums7 <= 9; nums7++) {
                    caches7 = caches8 + nums7;
                    for (nums6 = 0; nums6 <= 9; nums6++) {
                        caches6 = caches7 + nums6;
                        for (nums5 = 0; nums5 <= 9; nums5++) {
                            caches5 = caches6 + nums5;
                            for (nums4 = 0; nums4 <= 9; nums4++) {
                                caches4 = caches5 + nums4;
                                for (nums3 = 0; nums3 <= 9; nums3++) {
                                    caches3 = caches4 + nums3;
                                    for (nums2 = 0; nums2 <= 9; nums2++) {
                                        caches2 = caches3 + nums2;
                                        for (nums1 = 0; nums1 <= 9; nums1++, numBase+=10) {
                                            caches1 = caches2 + nums1;

                                            //////////////////////////////////////////////////
                                            // 因为只剩最后一位, 其他位已经确定             //
                                            // 而且所有位的和需要被9整除                    //
                                            // 根据这些现在可以直接计算出符合要求的最后一位 //
                                            //////////////////////////////////////////////////

                                            // 当前各位和的余数
                                            int remainder = caches1 % 9;

                                            // 根据余数求出符合要求的最后一位
                                            nums0 = 9 - remainder;

                                            // 求出当前要判断的数
                                            num = numBase + nums0;

                                            // 计数器累加
                                            count++;

                                            // 判断逻辑
                                            if (num >= Integer.MAX_VALUE || num < 0) {

                                                // 若到达最大整数, 则终止循环
                                                break outer;
                                            } else {
                                                // 判断是否违反假设, 即满足上面的条件但除9余数不为零
                                                if (num % 9 != 0) {

                                                    // 如果发现不符合假设的数字, 则输出它并终止程序
                                                    System.out.println("发现不符合假设的数字: " + num);
                                                    return;
                                                }
                                            }

                                            // 当余数为0时, 最后一位为0或9都符合
                                            // 但上面仅验证了为9的情况
                                            // 这里验证为0的情况
                                            if (remainder == 0) {
                                                nums0 = 0;

                                                // 求出当前要判断的数
                                                num = numBase + nums0;

                                                // 计数器累加
                                                count++;

                                                // 和上面相同的判断逻辑
                                                if (num >= Integer.MAX_VALUE || num < 0) {
                                                    break outer;
                                                } else {
                                                    if (num % 9 != 0) {
                                                        System.out.println("发现不符合假设的数字: " + num);
                                                        return;
                                                    }
                                                }
                                            }


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 验证完成, 输出结果
        System.out.println("全部非负整数 (0 - " + Integer.MAX_VALUE + ") 验证完成, 全部符合假设!");
        System.out.println("共计算" + count + "次");

        // 计时结束
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("用时: %ss", (endTime - startTime) / 1000.0));
    }

    private static boolean checkMaxValue(int num) {
        return num >= Integer.MAX_VALUE || num < 0;
    }

    private static void check(int num) throws Exception {
        if (num % 9 != 0) {

            // 如果发现不符合假设的数字, 则输出它并终止程序
            System.out.println("发现不符合假设的数字: " + num);
            throw new Exception();
        }
    }
}
