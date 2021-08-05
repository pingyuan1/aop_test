package com.aop.thread;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/7/8 15:28
 */
public class Noasync {

    public static int flag = 0;

    public static void main(String[] args) {


        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("flag+1 = "+getMethod()+1);
            }
        };
        System.out.println("当前线程名称："+thread.getName());
        thread.start();

        Thread1 thread1 = new Thread1();
        System.out.println("当前线程名称："+thread1.getName());
        thread1.start();



    }

    public static int getMethod(){
        return flag;
    }




}
