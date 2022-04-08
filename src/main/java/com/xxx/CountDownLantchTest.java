package com.xxx;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * description: 对CountdownLatch类进行测试，倒数类，当数量到达0时放行指定线程，只能使用一次
 * author: xhs 
 * date: 2022/4/8
 * version: 
 **/
public class CountDownLantchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println("begin.....");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("end......" + countDownLatch.getCount());
        }).start();

        new Thread(() -> {
            System.out.println("begin.....");
            try {
                sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("end......" + countDownLatch.getCount());
        }).start();

        new Thread(() -> {
            System.out.println("begin.....");
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("end......" + countDownLatch.getCount());
        }).start();

        try {
            System.out.println("主程序等待");
            countDownLatch.await();
            System.out.println("主程序执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
