package com.codeking.reflection;

/**
 * @author : codeking
 * @date : 2022/11/14 20:36
 */

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * * 要想实现动态代理，需要解决的问题？
 * * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */

/*
 * AOP与动态代理的举例
 */

// 先定义接口
interface Moon {
    String getBelief();

    void Object(String Moon);
}

// 定义被代理类
class Venus implements Moon {

    @Override
    public String getBelief() {
        return "我是Venus，我是被代理的，我正在执行 getBelief()";
    }

    @Override
    public void Object(String MinMoon) {
        System.out.println("通用代码1");
        System.out.println("我的附近有很多的 " + MinMoon);
        System.out.println("通用代码2");
    }
}

// 动态代理类
class DynamicProxyImpl {
    public static Object getProxyInstance(Object obj) {
        InvocationHandlerAdd handler = new InvocationHandlerAdd();
        // 将对象绑定赋值
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class InvocationHandlerAdd implements InvocationHandler {
    private Object obj;

    // 写一个方法实现这个赋值的操作
    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}


public class DynamicProxy {

    @Test
    public void testDynamicProxy() {
        Venus sun = new Venus();
        // 动态的 创建代理对象
        Moon ProxyVer = (Moon) DynamicProxyImpl.getProxyInstance(sun);
        //当通过代理类对象调用方法时，会自动调用被代理类中同名的方法
        String MyBelief = ProxyVer.getBelief();
        System.out.println("MyBelief" + MyBelief);
        ProxyVer.Object("小行星");
        System.out.println("+++++++++++++++++++");

    }
}
