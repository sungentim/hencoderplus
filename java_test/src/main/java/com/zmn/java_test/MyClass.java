package com.zmn.java_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyClass {
    private static InvocationHandler handler = new InvocationHandler() {
        @Override
        public Object invoke(Object o, Method method, Object[] args) throws Throwable {
            System.out.println(method);
            if (method.getName().equals("sayHello")) {
                System.out.println("Good morning, " + args[0]);
            }
            return null;
        }
    };

    public static void main(String[] args) {
        TestProxy hello = (TestProxy) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{TestProxy.class}, handler);
        hello.sayHello("Tim");
    }
}