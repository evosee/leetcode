package com.test.algorithm.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/18 14:06
 */
public class Text1134B {

    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch2;

    public Text1134B() {
        countDownLatch = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        countDownLatch.countDown();
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatch.await();
        printSecond.run();
        countDownLatch2.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatch2.await();
        printThird.run();
    }
}
