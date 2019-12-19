package com.test.algorithm.thread;

import java.util.function.IntConsumer;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/19 11:04
 */
public class Text1116 {

    private int n;
    private int f;

    public Text1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            while (f!=0){
                Thread.yield();
            }

            printNumber.accept(i);
            if(i%2==0){
                f = 1;
            }else {
                f= 2;
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;){
            while (f!=1){
                Thread.yield();
            }
            printNumber.accept(i);
            i+=2;
            f = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;){
            while (f!=2){
                Thread.yield();
            }
            printNumber.accept(i);
            i+=2;
            f = 0;
        }
    }

    public static void main(String[] args) {
        Text1116 text1116 = new Text1116(2);
        Thread thread = new Thread(()->{
            try {
                text1116.zero(e-> System.out.println(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(()->{
            try {
                text1116.odd(e-> System.out.println(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                text1116.even(e-> System.out.println(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread1.start();
        thread2.start();
    }


}
