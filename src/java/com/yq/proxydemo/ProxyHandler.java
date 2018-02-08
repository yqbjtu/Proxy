package com.yq.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyHandler implements InvocationHandler {
   private Object obj;

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable {
        before();

        /**
        *用反射机制调用了method方法
        **/
        System.out.println("调用" + method.getName() + "方法， with " + args.length + "个参数:"+ Arrays.toString(args));
        Object object = method.invoke(obj, args);

        after();
        return object;
    }

    //Advice(通知)
    public void before() {
        System.out.println("代理前的处理操作"); 
    }

    //Advice(通知)
    public void after() {
        System.out.println("代理后的处理操作");
    }
}
