package com.aop.test;


import com.aop.common.He;


/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/10 14:56
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        Class heClass = He.class;
        He he1  = new He();
        He he2  = new He();
        Class<? extends He> getClass1 = he1.getClass();
        Class<? extends He> getClass2 = he2.getClass();

        System.out.println(heClass==getClass1);
        System.out.println(heClass==getClass2);
        System.out.println(getClass1==Class.forName("com.aop.common.He"));
        System.out.println(getClass2==Class.forName("com.aop.common.He"));
        System.out.println(getClass1==getClass2);

    }
}
