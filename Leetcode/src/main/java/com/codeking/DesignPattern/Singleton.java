package com.codeking.DesignPattern;

import java.io.Serializable;

/**
 * @author CodeKing
 * @since 2023/4/10  20:41
 */
public class Singleton {
    public static void main(String[] args) {
        SingletonHunger singletonHunger = SingletonHunger.newInstance();
        System.out.println("singletonHunger = " + singletonHunger);
        SingletonHunger singletonHunger1 = singletonHunger.newInstance();
        System.out.println("singletonHunger1 = " + singletonHunger1);
        SingletonHunger singletonHunger2 = singletonHunger.newInstance();
        System.out.println("singletonHunger2 = " + singletonHunger2);
        System.out.println("**SingletonEnum**");
        SingletonEnum singletonEnum = SingletonEnum.newInstance();
        SingletonEnum singletonEnum2 = SingletonEnum.newInstance();
        System.out.println("singletonEnum = " + singletonEnum);
        System.out.println("singletonEnum2 = " + singletonEnum2);
        System.out.println("饿汉式****");
        SingletonLazy singletonLazy = SingletonLazy.newInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.newInstance();
        System.out.println("singletonLazy = " + singletonLazy);
        System.out.println("singletonLazy1 = " + singletonLazy1);
        System.out.println("双检锁懒汉式**");
        SingletonLazyDLC singletonLazyDLC=SingletonLazyDLC.newInstance();
        SingletonLazyDLC singletonLazyDLC1=SingletonLazyDLC.newInstance();
        System.out.println("singletonLazyDLC = " + singletonLazyDLC);
        System.out.println("singletonLazyDLC1 = " + singletonLazyDLC1);
        System.out.println("内部类懒汉式****");
        SingletonLazyStatic singletonLazyStatic = SingletonLazyStatic.newInstance();
        SingletonLazyStatic singletonLazyStatic1 = SingletonLazyStatic.newInstance();
        System.out.println("singletonLazyStatic = " + singletonLazyStatic);
        System.out.println("singletonLazyStatic1 = " + singletonLazyStatic1);
    }

}

// 饿汉式
class SingletonHunger implements Serializable {
    private SingletonHunger() {
        if (myInstance == null) {
            System.out.println("实例化");
        }
    }

    private static final SingletonHunger myInstance = new SingletonHunger();

    public static SingletonHunger newInstance() {
        return myInstance;
    }

    // 解决防止反序列化破坏单例
    public Object readResolve() {
        return myInstance;
    }
}


// 枚举饿汉式
enum SingletonEnum {
    MySingleton;

    SingletonEnum() {
        System.out.println("SingletonEnum实例化");
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public static SingletonEnum newInstance() {
        return MySingleton;
    }
}


// 懒汉式
class SingletonLazy {
    public SingletonLazy() {
        System.out.println("饿汉式实例化");
    }

    private static SingletonLazy myInstance = null;

    public static SingletonLazy newInstance() {
        if (myInstance == null) {
            myInstance = new SingletonLazy();
        }
        return myInstance;
    }
}

//双检锁懒汉式
class SingletonLazyDLC {
    public SingletonLazyDLC() {
        System.out.println("双检锁懒汉式实例化...");
    }

    // volatile 保证其顺序一致性
    private static volatile SingletonLazyDLC myInstance ;

    public static SingletonLazyDLC newInstance() {
        // 这个是首次创建的时候需要校验
        if (myInstance == null) {
            // 加锁
            synchronized (SingletonLazyDLC.class) {
                if (myInstance == null) {
                    myInstance = new SingletonLazyDLC();
                }
            }
        }
        return myInstance;
    }
}
//内部类懒汉式

class SingletonLazyStatic {
    public SingletonLazyStatic() {
        System.out.println("内部类懒汉式实例化....");
    }

    static SingletonLazyStatic myInstance;
    // 内部方法
    public static  void newIt() {
        myInstance= new SingletonLazyStatic();
    }



    public static SingletonLazyStatic newInstance() {
        if (myInstance == null) {
            newIt();
        }
        return myInstance;
    }
}