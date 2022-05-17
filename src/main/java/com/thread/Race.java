package com.thread;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author LYP
 * @date 2022/2/4 4:26 PM 龟兔赛跑
 */
public class Race implements Runnable {

    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            String threadName = Thread.currentThread().getName();
            //兔子会睡觉
            if ("🐰".equals(threadName) && i == 99) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (gameOver(i)) {
                break;
            }

            if (i > 90) {
                System.out.println(threadName + "跑了" + i + "步");
            }
        }
    }

    private boolean gameOver(int i) {
        if(ObjectUtil.isNotEmpty(winner)){
            return true;
        }
        if (i == 100) {
            winner = Thread.currentThread().getName();
            System.out.println(Thread.currentThread().getName() + "取得了胜利");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //启用线程
        new Thread(new Race(), "🐢").start();
        new Thread(new Race(), "🐰").start();

    }

}
