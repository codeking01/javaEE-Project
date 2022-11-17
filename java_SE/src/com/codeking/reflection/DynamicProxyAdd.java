package com.codeking.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : codeking
 * @date : 2022/11/17 11:56
 */

interface student {
    void study(String course);
}

// 定义创建被代理类
class studentProxy implements student{

    @Override
    public void study(String course) {
        System.out.println("通用代码1");
        System.out.println("我要学习 "+course);
        System.out.println("通用代码2");
    }
}

// 创建动态代理类，其实这个并不是真正的代理类，只是实现调用代理类的逻辑，真的是在内存中生成的代理类
class ProxyInvocationHandler implements InvocationHandler {
    // 定义被代理的对象
    private Object target;

    // 动态创建代理对象
    public Object createProxy(Object o){
        // 将被代理对象赋值
        this.target = o;
        ClassLoader cls=target.getClass().getClassLoader();
        Class<?>[] interfaces=target.getClass().getInterfaces();
        Object proxyObject= Proxy.newProxyInstance(cls, interfaces,this);
        return proxyObject;
    }

    // 实现代理逻辑，真正的代理对象（实现了这个类），会直接调用这个方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法前");
        Object invoke = method.invoke(target, args);
        System.out.println("调用方法后");
        return invoke;
    }
}


public class DynamicProxyAdd {
    public static void main(String[] args) {
        //定义被代理对象
        student studentProxy1=new studentProxy();
        student proxy = (student) new ProxyInvocationHandler().createProxy(studentProxy1);
        proxy.study("数学");
    }
}
