package com.test.algorithm.thread;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/18 10:52
 * <p>
 * 线程交替打印
 * 3个线程交替打印
 */
public class Text1134 {

    private volatile boolean first;
    private volatile boolean second;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        first = true;
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (true) {
            if(first){
                printSecond.run();
                second = true;
                break;
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true) {
            if(second){
                printThird.run();
                break;
            }

        }
    }

    public static void main(String[] args) {
        Text1134 text1134 = new Text1134();
        Runnable runnable = () -> System.out.println("one");
        Runnable runnable2 = () -> System.out.println("two");
        Runnable runnable3 = () -> System.out.println("three");

        Thread thread = new Thread(() -> {
            try {
                text1134.first(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                text1134.second(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3= new Thread(() -> {
            try {
                text1134.third(runnable3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
    }
}
