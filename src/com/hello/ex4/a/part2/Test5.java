package com.hello.ex4.a.part2;

/**
 * // 找出并改正以下代码中的错误:
 * public class Test5 {
 *
 *     public static void main(String[] args) {
 *         A a = new A(); // <-- 这里有错, 因为A类没有无参构造器
 *         a.print();
 *     }
 * }
 *
 * class A {
 *     String s;
 *     A(String s) {
 *         this.s = s;
 *     }
 *     public void print() {
 *         System.out.println(s);
 *     }
 * }
 *
 * 错误原因: A类没有无参构造器
 *      因为A类已经实现了一个有参构造器,
 *      所以编译器不再自动为其添加无参构造器,
 *      导致调用无参构造器创建A实例时出现错误
 *
 * 改正方法:
 *      1. 提供无参构造器
 *      2. 传递适当的参数给A的有参构造器
 *
 * 使用方法2改正后的代码如下
 */
public class Test5 {

    public static void main(String[] args) {
        A a = new A("改正方法: 提供适当的参数给A的有参构造器器");
        a.print();
    }
}

class A {
    String s;
    A(String s) {
        this.s = s;
    }
    public void print() {
        System.out.println(s);
    }
}
