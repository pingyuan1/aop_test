package com.aop.thread;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/7/8 15:39
 */
public class Thread1 extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("flag+2 = "+Noasync.getMethod()+2);
    }
}
