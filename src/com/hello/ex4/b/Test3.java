package com.hello.ex4.b;

public class Test3 {

    // @Test
    public static void main(String[] args) {

        // 先调用父类构造器 SuperClass()
        //   -> In SuperClass: x = 3
        // 然后后调用子类构造器 SubClass()
        //   -> In SubClass: x = 5
        SubClass subClass = new SubClass();

        // 先调用 SuperClass.doSomething()
        //   -> In SuperClass.doSomething()
        // 然后后调用子类 SubClass.doSomething()
        //   -> In SubClass.doSomething()
        //   -> Super.x = 3, Sub.x = 5
        subClass.doSomething();
    }
}

class SubClass extends SuperClass {
    int x; // 覆盖了 SuperClass.x
    SubClass() {
        super();
        x = 5;
        System.out.println("In SubClass: x = " + x);
    }
    void doSomething() {
        super.doSomething();
        System.out.println("In SubClass.doSomething()");
        System.out.println("Super.x = " + super.x + ", Sub.x = " + x);
    }
}

class SuperClass {
    int x;
    SuperClass() {
        x = 3;
        System.out.println("In SuperClass: x = " + x);
    }
    void doSomething() {
        System.out.println("In SuperClass.doSomething()");
    }
}