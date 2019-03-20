package com.hello.ex3;

public class Test6PPPlus {

    public static void main(String[] args) {

        // 计时开始
        long startTime = System.currentTimeMillis();

        // 当前要判断的数字
        int num = 0;

        // 用于保存数字的每一位,省去提取每一位的时间
        // 因为int类型最大(2147483647)仅有10位, 故使用长度为10的数组
        // nums[0]代表最低位, nums[9]代表最高位
        int[] nums = new int[10];
        
        // 个位为0的当前数字
        // 在第9层循环每次累加10
        // num = numBase + nums[0]
        int numBase = 0;

        // Cache
        int cache = 0;

        // 计算次数计数
        int count = 0;

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
                                        for (nums[1] = 0; nums[1] <= 9; nums[1]++, numBase += 10) {
                                            cache += nums[1];

                                            //////////////////////////////////////////////////
                                            // 因为只剩最后一位, 其他位已经确定             //
                                            // 而且所有位的和需要被9整除                    //
                                            // 根据这些现在可以直接计算出符合要求的最后一位 //
                                            //////////////////////////////////////////////////

                                            // 当前各位和的余数
                                            int remainder = cache % 9;

                                            // 根据余数求出符合要求的最后一位
                                            nums[0] = 9 - remainder;

                                            // 求出当前要判断的数
                                            num = numBase + nums[0];

                                            // 计数器累加
                                            count++;

                                            // 判断逻辑
                                            if (num >= Integer.MAX_VALUE || num < 0) {

                                                // 若到达最大整数或溢出, 则终止循环
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
                                                nums[0] = 0;

                                                // 求出当前要判断的数
                                                num = numBase + nums[0];

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
        System.out.println("共计算" + count + "次");

        // 计时结束
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("用时: %ss", (endTime - startTime) / 1000.0));
    }
}
