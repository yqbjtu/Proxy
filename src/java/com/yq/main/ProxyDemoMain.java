package com.yq.main;

import java.lang.reflect.Proxy;

import com.yq.proxydemo.DemoClass;
import com.yq.proxydemo.IDemo;
import com.yq.proxydemo.ProxyHandler;

public class ProxyDemoMain {

    public static void main(String[] args) {

        DemoClass demo = new DemoClass();
        /**
        *创建代理处理器
        **/
        ProxyHandler handler = new ProxyHandler(demo);
        /**
        *创建代理对象
        **/
        IDemo proxy = (IDemo) Proxy.newProxyInstance(demo.getClass().getClassLoader(), 
            demo.getClass().getInterfaces(),
            handler);
        /**
        *调用方法
        **/
        int count = proxy.addMethod(11, 7);  //执行了11+7操作 并在该操作前后调用了附加方法
        System.out.println("11 + 7 = " + count);

        System.out.println();
        int result = proxy.subtractMethod(12, 9, 5);  //执行了12-9 -5操作 并在该操作前后调用了附加方法
        System.out.println("12 - 9 -5 = " + result);

        //proxy 无法调用maxMethod 方法
        System.out.println();
        int max = demo.maxMethod(12, 9);
        System.out.println("12 与9 中比较大的是" + max);

        //demo直接调用addMethod方法
        System.out.println();
        int addResult = demo.addMethod(12, 9);
        System.out.println("（直接从DemoClass调用maxMethod方法）。 12 与9之和是   " + addResult);
        
    }

}
