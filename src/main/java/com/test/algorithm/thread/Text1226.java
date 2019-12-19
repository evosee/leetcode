package com.test.algorithm.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/19 17:42
 */
public class Text1226 {
    private Semaphore semaphore = new Semaphore(4);
    private ReentrantLock[] reentrantLocks = {new ReentrantLock(),new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = (philosopher+1)%5;
        int right = philosopher;
        semaphore.acquire();
        reentrantLocks[left].lock();
        reentrantLocks[right].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        reentrantLocks[left].unlock();
        reentrantLocks[right].unlock();
        semaphore.release();
    }
}
