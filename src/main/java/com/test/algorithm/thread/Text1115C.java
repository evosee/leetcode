package com.test.algorithm.thread;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/19 10:09
 */
public class Text1115C {

    private int n;
    private volatile boolean flag = true;

    public Text1115C(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag) {
                Thread.yield();
            }

            printFoo.run();
            flag = false;
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
    }


    public void bar(Runnable printBar) throws Exception {
        for (int i = 0; i < n; i++) {
            while (flag) {
                Thread.yield();
            }
            printBar.run();
            flag = true;
        }
    }

    public static void main(String[] args) {
        Text1115C text1115 = new Text1115C(5);
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
