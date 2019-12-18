package com.test.algorithm.thread;


/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/18 14:39
 */
public class Text1115B {

    private volatile boolean first = true;
    private volatile boolean second;
    private Object lock = new Object();
    private int n;

    public Text1115B(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (first) {
                    printFoo.run();
                    first = false;
                    second = true;

                } else {
                    lock.wait();
                    printFoo.run();
                    first = false;
                    second = true;
                }
                lock.notifyAll();
            }
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
    }


    public void bar(Runnable printBar) throws Exception {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (second) {
                    printBar.run();
                    second = false;
                    first = true;

                } else {
                    lock.wait();
                    printBar.run();
                    second = false;
                    first = true;
                }
                lock.notifyAll();
            }
        }

    }


    public static void main(String[] args) {


            Text1115B text1115 = new Text1115B(5);
            Runnable runnable = ()-> System.out.print("foo");
            Runnable runnable2 = ()-> System.out.println("bar");
            Thread thread = new Thread(()->{
                try {
                    text1115.foo(runnable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Thread thread2 = new Thread(()->{
                try {
                    text1115.bar(runnable2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            thread.start();
            thread2.start();


    }
}
