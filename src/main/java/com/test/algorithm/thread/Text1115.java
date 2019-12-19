package com.test.algorithm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/18 14:39
 */
public class Text1115 {

    private volatile boolean first = true;
    private volatile boolean second;
    private Lock reenLock = new ReentrantLock();
    private Condition condition = reenLock.newCondition();
    private int n;

    public Text1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws Exception {

        for (int i = 0; i < n; i++) {

            try {
                reenLock.lock();
                if (first) {
                    printFoo.run();
                    first = false;
                    second = true;
                } else {
                    condition.await();
                    printFoo.run();
                    first = false;
                    second = true;
                }
                condition.signalAll();
            }finally {
                reenLock.unlock();
            }
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
    }


    public void bar(Runnable printBar) throws Exception {
        for(int i=0;i<n;i++){
            try {
                reenLock.lock();
                if (second) {
                    printBar.run();
                    second = false;
                    first = true;
                } else {
                    condition.await();
                    printBar.run();
                    second = false;
                    first = true;
                }
                condition.signalAll();
            }finally {
                reenLock.unlock();
            }

        }

    }


    public static void main(String[] args) {


            Text1115 text1115 = new Text1115(5);
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
