package com.atguigu.java;

/**
 * 多线程第一种创建方式
 * @author fyq
 * @create 2022-04-19 21:31
 */
public class TreadTest extends Thread{


    @Override
    public void run() {

        System.out.println("********************");
        System.out.println(getName());
        System.out.println("********************");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread.currentThread();
        TreadTest treadTest = new TreadTest(); // 主线程
        treadTest.start(); // 主线程调用start，启动子线程
        System.out.println("Hello World"); // 主线程同时执行print，与子线程的输出无直接先后关系
    }
}
