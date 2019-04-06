package com.hello.ex4.b;

public class Test2 {

    // @Test
    public static void main(String[] args) {
        B m = new B();

        // 调用 A.sum1() -> A.sum = A.num1 + A.num2 = 10 + 0 = 10;
        System.out.println("m.sum1():");
        m.sum1();

        // 调用 B.sum2() -> A.sum = A.num1 + B.num2 = 10 + 200 = 210;
        System.out.println("-------\nm.sum2():");
        m.sum2();

        // 调用 B.sum2(50) -> A.sum = A.num1 + B.num2 = 50 + 200 = 250;
        System.out.println("-------\nm.sum2(50):");
        m.sum2(50);

        // 会输出两行
        // 第一行来自 A.sum3(50) -> A.sum = A.num1 + A.num2 = 50 + 0 = 50;
        // 第二行来自 B.sum2(50) -> A.sum = A.num1 + B.num2 = 50 + 200 = 50;
        System.out.println("-------\nm.sum3(50):");
        m.sum3(50);
    }
}

class B extends A {

    int num2;

    /**
     * 调用之前先调用了 A(), 设置了 A.num1=10, A.num2=0, A.sum=0
     * 然后在此构造器里设置了 B.num2=200
     */
    public B() {
        num2 = 200; // B.num2 = 200;
    }

    /**
     * 对 A.sum2(int) 的重载
     * 新增的方法
     *      - 只能通过 B 访问, 无法通过 A 访问
     */
    void sum2() {
        sum = num1 + num2; // A.num1 = A.num1 + B.num2 = 10 + 200 = 210;
        System.out.println("sum = " + num1 + " + " + num2 + " = " + sum);
        // Output -> A.sum = A.num1 + B.num2 = 10 + 200 = 210;
    }

    /**
     * 对 A.sum2(int) 的重写
     */
    void sum2(int n) { // n = 50;
        num1 = n; // A.num1 = n = 50;
        sum = num1 + num2; // A.sum = A.num1 + B.num2 = 50 + 200 = 250;
        System.out.println("sum = " + num1 + " + " + num2 + " = " + sum);
        // Output -> A.sum = A.num1 + B.num2 = 50 + 200 = 250;
    }

    /**
     * 新增的方法
     *      - 只能通过 B 访问, 无法通过 A 访问
     */
    void sum3(int n) {
        super.sum2(n); // A.sum = A.num1 + A.num2 = 50 + 0 = 50;
        System.out.println("sum = " + num1 + " + " + num2 + " = " + sum);
        // Output -> A.sum = A.num1 + B.num2 = 50 + 200 = 50;
    }
}

class A {

    int sum, num1, num2;

    public A() {
        num1 = 10;
        num2 = 0;
        sum = 0;
    }

    void sum1() {
        sum = num1 + num2; // A.sum = A.num1 + A.num2 = 10 + 0 = 10;
        System.out.println("sum = " + num1 + " + " + num2 + " = " + sum);
        // Output -> A.sum = A.num1 + A.num2 = 10 + 0 = 10;
    }

    void sum2(int n) { // n = 50;
        num1 = n; // A.num1 = n = 50;
        sum = num1 + num2; // A.sum = A.num1 + A.num2 = 50 + 0 = 50;
        System.out.println("sum = " + num1 + " + " + num2 + " = " + sum);
        // Output -> A.sum = A.num1 + A.num2 = 50 + 0 = 50;
    }
}
