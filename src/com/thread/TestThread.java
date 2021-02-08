package com.thread;

/**
 * 两线程交替输出
 */
public class TestThread {

    public static void main(String[] args) {
        final Object object = new Object();
        Runnable runnable = () -> {
            for (int i = 1; i <= 5; i++) {
                synchronized (object) {
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable1 = () -> {
            for (int i = 6; i <= 10; i++) {
                synchronized (object) {
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable1).start();

    }

}
