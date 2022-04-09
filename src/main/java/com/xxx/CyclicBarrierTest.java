package com.xxx;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

/**
 * description: 测试CyclicBarrier类，栅栏类，当所有线程到达指定点后才会执行
 * author: xhs 
 * date: 2022/4/8
 * version: 
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            System.out.println("线程1开始计数" + new Date());
            try {
                cyclicBarrier.await(); // 当未达到计数要求时，停止等待
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程1继续运行" + new Date());
        }).start();

        new Thread(() -> {
            System.out.println("线程2开始计数" + new Date());
            try {
                sleep(2000);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程2继续运行" + new Date());
        }).start();


    }
}
