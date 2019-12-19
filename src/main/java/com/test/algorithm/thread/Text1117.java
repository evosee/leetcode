package com.test.algorithm.thread;

import java.util.concurrent.Semaphore;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/19 15:13
 */
public class Text1117 {
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h.acquire(1);
        releaseHydrogen.run();
        o.release(1);

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }
}
