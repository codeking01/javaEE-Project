package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/9 15:39
 */
public class LambdaTest {
    //②静态内部类
    /*static class Test implements MyTest {
        @Override
        public void lambdaTest() {
            System.out.println("lambda test");
        }
    }*/
    public static void main(String[] args) {
        //③局部内部类
        /*class Test implements MyTest {
            @Override
            public void lambdaTest() {
                System.out.println("lambda test");
            }
        }*/
        //④匿名内部类
        /*MyTest t1 = new MyTest() {
            @Override
            public void lambdaTest() {
                System.out.println("lambda test");
            }
        };*/
        //⑤Lambda表达式 只有函数式接口才可以用这个
        MyTest t1 = () -> {
            System.out.println("lambda test");
        };
        t1.lambdaTest();
    }
}

interface MyTest {
    void lambdaTest();
}

/*①实现类
class Test implements MyTest {
    @Override
    public void lambdaTest() {
        System.out.println("lambda test");
    }
}*/
