package com.xxx;

import java.util.concurrent.Semaphore;

/**
 * description: 对Semaphore类进行测试，信号量，用于限制能同时访问共享资源的上限
 * author: xhs 
 * date: 2022/4/8
 * version: 
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0; i<10; i++){
            new Thread(){
                @Override
                public void run() {
                    // 获得许可
                    try{
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try{
                        System.out.println("running....");
                        sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("释放许可....");
                        semaphore.release();
                    }
                }
            }.start();
        }
    }
}
