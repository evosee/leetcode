package com.test.algorithm.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/19 15:52
 */
public class Text1195 {
    private int n;

    public Text1195(int n) {
        this.n = n;
    }

    Semaphore fizzbuzz = new Semaphore(1);
    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore number = new Semaphore(0);

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (atomicInteger.get() <=n) {
            fizz.acquire(1);
            if(atomicInteger.get()<=n){
                if (atomicInteger.get() % 3 == 0) {
                    printFizz.run();
                    atomicInteger.getAndIncrement();
                    fizzbuzz.release(1);
                }else {
                    buzz.release(1);
                }
            }


        }
        buzz.release(1);
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (atomicInteger.get() <=n) {
            buzz.acquire(1);
            if(atomicInteger.get()<=n){
                if (atomicInteger.get() % 5 == 0) {
                    printBuzz.run();
                    atomicInteger.getAndIncrement();
                }
            }
            fizzbuzz.release(1);

        }
        fizzbuzz.release(1);
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (atomicInteger.get() <=n) {
            fizzbuzz.acquire(1);
            if(atomicInteger.get()<=n){
                if (atomicInteger.get() % 3 == 0 && atomicInteger.get() % 5 == 0) {
                    printFizzBuzz.run();
                    atomicInteger.getAndIncrement();
                }
                number.release(1);
            }

        }
        number.release(1);

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        while (atomicInteger.get() <= n) {
            number.acquire(1);
            if(atomicInteger.get() <= n){
                if (atomicInteger.get() % 3 != 0 && atomicInteger.get() % 5 != 0) {
                    printNumber.accept(atomicInteger.get());
                    atomicInteger.getAndIncrement();
                    fizzbuzz.release(1);
                } else {
                    fizz.release(1);
                }
            }


        }
        fizz.release(1);

    }


    public static void main(String[] args) {
        Text1195 text1195 = new Text1195(15);
        Thread thread = new Thread(() -> {
            try {
                text1195.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                text1195.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                text1195.fizzbuzz(() -> System.out.println("fizzBuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                text1195.number(e -> System.out.println(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
