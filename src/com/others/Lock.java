package com.others;

public class Lock {

    synchronized static void fun1() throws InterruptedException {
        System.out.println("加锁的方法1开始执行");
        Thread.sleep(2000);
        System.out.println("加锁的方法1执行结束");
    }

    synchronized static void fun2() throws InterruptedException {
        System.out.println("加锁的方法2开始执行");
        Thread.sleep(2000);
        System.out.println("加锁的方法2执行结束");
    }

    public static void main(String[] args) {
        Lock obj1 = new Lock();
        Lock obj2 = new Lock();

        new Thread(() -> {
            try {
                obj1.fun1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                obj1.fun2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
