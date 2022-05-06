package com.atguigu.java;

/**
 * @author shkstart
 * @create 2022-04-20 14:29
 */
public class TreadTest2 {
    public static void main(String[] args) {
        TreadDemo treadDemo = new TreadDemo();
        Thread t1 = new Thread(treadDemo);
        t1.start();

    }
}

class TreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}


