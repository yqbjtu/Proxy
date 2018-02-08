package com.yq.main;

import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyDemoLambda {

    public static void main(String[] args) {
        Object[] values = new Object[1000];
        for (int i = 0; i < values.length; i++) {
        Object value = new Integer(i);
        values[i] = Proxy.newProxyInstance(
            null,
            value.getClass().getInterfaces(),
            // 调用处理器的lambda表达式
            (Object proxy, Method m, Object[] margs) -> {
                System.out.println("before method call");
                System.out.println(value + "." + m.getName() + Arrays.toString(margs));
                Object obj = m.invoke(value, margs);
                System.out.println("after method call");
                return obj;
            });
        }

        Arrays.binarySearch(values, new Integer(500));
    }

}
