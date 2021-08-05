package com.aop.common;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/16 11:12
 */
public class He {

    public String show() {
        return "是个人";
    }

    public String show(String name) {
        return name + "是个人";
    }
    public String show(String name,String age) {
        return name + "是个人";
    }

    public String friend(String name, String meFriend) {
        return meFriend + "是" + name + "的朋友";
    }

    public String friend(String name, String meFriend, String[] friend) {

        StringBuffer string = new StringBuffer(meFriend + "是" + name + "的朋友" + name + "还有一些朋友比如：");

        for (String str : friend) {
            string.append(str + "\t");
        }

        return string.toString();
    }

}


