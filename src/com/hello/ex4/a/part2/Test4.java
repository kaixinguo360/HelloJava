package com.hello.ex4.a.part2;

public class Test4 {

    // @Test
    public static void main(String[] args) {

        // SuperThisUseDemo
        new ZhangSan().superThisUseDemo();
    }
}

class Person {

    // 父类的weight变量, 会被子类的同名变量覆盖
    int weight;

    Person() {
        // 父类的weight变量
        weight = 50;
    }

    void printPerson() {
        System.out.println("Person.printPerson()");
    }
}

class ZhangSan extends Person {

    // 覆盖了父类的同名变量,
    // 若想访问父类中的weight变量,
    // 则要用super.weight
    int weight;

    ZhangSan() {

        // 调用父类的构造器, 其实为多余的
        // 原因: 当父类有无参构造器时,子类构造时会自动调用父类的无参构造器
        super();

        // 将本类的weight设置为500,
        // 父类的weight依旧为初始化时的50
        weight = 500;
    }

    // 覆盖了父类的同名方法,
    // 若想访问父类中的printPerson方法,
    // 则要用super.printPerson()
    void printPerson() {
        System.out.println("ZhangSan.printPerson()");
    }

    // @Test
    void superThisUseDemo() {

        // 方法测试
        super.printPerson(); // 调用父类方法
        printPerson(); // 调用自己方法

        // 属性测试
        int weight = 5000;
        System.out.println("super.weight = " + super.weight); // 来自父类
        System.out.println("this.weight = " + this.weight); // 来自自己
        System.out.println("weight = " + weight); // 来自局部变量
    }
}