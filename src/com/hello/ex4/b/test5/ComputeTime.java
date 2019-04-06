package com.hello.ex4.b.test5;

public class ComputeTime {

    // @Test
    public static void main(String[] args) {
        if (args.length == 4) {
            try {
                // 获取输入参数
                String className = args[0];
                int a = Integer.valueOf(args[1]);
                int b = Integer.valueOf(args[2]);
                int c = Integer.valueOf(args[3]);

                // 创建指定交通工具类
                ICommon common = getInstance(className);

                // 设置参数
                common.setParams(a, b, c);

                // 计算运行1000米所需的时间
                double time = 1000 / common.getSpeed();
                System.out.println(className + " 的速度: " + common.getSpeed());
                System.out.println(className + " 运行1000米所需的时间: " + time);

            } catch (NumberFormatException e) {
                System.out.println("参数格式错误: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("未知交通工具: " + args[0]);
            }
        } else {
            System.out.println("参数数目错误!");
        }
    }

    /**
     * 创建并返回指定类的一个实例
     */
    private static ICommon getInstance(String className) throws ClassNotFoundException {

        // 获取类的全限定名, 默认新的类必须放在与 ComputeTime 相同的包下
        String fullName = ComputeTime.class.getPackage().getName() + "." + className;

        // 获取指定 Class
        Class clazz = Class.forName(fullName);

        // 判断获得的 Class 是否符合要求
        if (clazz == null || !ICommon.class.isAssignableFrom(clazz)) {
            throw new ClassNotFoundException();
        }

        // 使用获得的 Class 创建实例并返回
        try {
            return (ICommon) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}