package com.yq.proxydemo;

public class DemoClass implements IDemo {

    @Override
    public int addMethod(int a, int b) {
        return a + b;
    }

    @Override
    public int subtractMethod(int a, int b, int c) {
        return a - b - c;
    }

    public int maxMethod(int a, int b) {
        return (a > b) ? a : b ;
    }
}
