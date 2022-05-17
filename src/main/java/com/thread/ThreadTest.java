package com.thread;

/**
 * @author LYP
 * @date 2022/2/4 4:26 PM
 * 继承Thread类，实现多线程调用
 */
public class ThreadTest extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("🍊测试" + i);
        }
    }

    public static void main(String[] args) {
        //启用线程
        new ThreadTest().start();
        //线程测试
        for (int i = 0; i < 30; i++) {
            System.out.println("线程测试" + i);
        }
    }
}
