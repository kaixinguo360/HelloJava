package com.hello.ex3;

public class Test6PPlus {

    public static void main(String[] args) {

        // 计时开始
        long startTime = System.currentTimeMillis();

        // 当前要判断的数字
        int num = 0;

        // 用于保存数字的每一位,省去提取每一位的时间
        // 因为int类型最大(2147483647)仅有10位, 故使用长度为10的数组
        // nums[0]代表最低位, nums[9]代表最高位
        int[] nums = new int[10];

        // Cache
        int cache = 0;

        // 从0到9依次遍历nums[]数组的每一位
        // 最内层循环顺带递增num
        outer:
        for (nums[9] = 0; nums[9] <= 9; nums[9]++) {
            cache += nums[9];
            for (nums[8] = 0; nums[8] <= 9; nums[8]++) {
                cache += nums[8];
                for (nums[7] = 0; nums[7] <= 9; nums[7]++) {
                    cache += nums[7];
                    for (nums[6] = 0; nums[6] <= 9; nums[6]++) {
                        cache += nums[6];
                        for (nums[5] = 0; nums[5] <= 9; nums[5]++) {
                            cache += nums[5];
                            for (nums[4] = 0; nums[4] <= 9; nums[4]++) {
                                cache += nums[4];
                                for (nums[3] = 0; nums[3] <= 9; nums[3]++) {
                                    cache += nums[3];
                                    for (nums[2] = 0; nums[2] <= 9; nums[2]++) {
                                        cache += nums[2];
                                        for (nums[1] = 0; nums[1] <= 9; nums[1]++) {
                                            cache += nums[1];
                                            for (nums[0] = 0; nums[0] <= 9; nums[0]++, num++) {
                                                if (num >= Integer.MAX_VALUE) {

                                                    // 若到达最大整数, 则终止循环
                                                    break outer;
                                                } else {

                                                    // 判断是否违反假设, 即满足各位数之和除9的余数为零但原数除9余数不为零
                                                    // 因为求余运算量较小, 根据短路原理把它放到前面
                                                    if (num % 9 != 0 && (cache + nums[0]) % 9 == 0) {

                                                        // 如果发现不符合假设的数字, 则输出它并终止程序
                                                        System.out.println("发现不符合假设的数字: " + num);
                                                        return;
                                                    }
                                                }
                                            }
                                            cache -= nums[1];
                                        }
                                        cache -= nums[2];
                                    }
                                    cache -= nums[3];
                                }
                                cache -= nums[4];
                            }
                            cache -= nums[5];
                        }
                        cache -= nums[6];
                    }
                    cache -= nums[7];
                }
                cache -= nums[8];
            }
            cache -= nums[9];
        }

        // 验证完成, 输出结果
        System.out.println("全部非负整数 (0 - " + Integer.MAX_VALUE + ") 验证完成, 全部符合假设!");

        // 计时结束
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("用时: %ss", (endTime - startTime) / 1000.0));
    }
}
