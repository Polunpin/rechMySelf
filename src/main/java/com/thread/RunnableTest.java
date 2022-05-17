package com.thread;

/**
 * @author LYP
 * @date 2022/2/4 4:26 PM
 * 实现Runnable接口，实现多线程调用 推荐使用
 */
public class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("🍊测试" + i);
        }
    }

    public static void main(String[] args) {
        //启用线程
        new Thread(new RunnableTest()).start();
        //线程测试
        for (int i = 0; i < 30; i++) {
            System.out.println("🍇测试" + i);
        }
    }
}
