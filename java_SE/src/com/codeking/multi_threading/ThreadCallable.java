package com.codeking.multi_threading;

import java.util.concurrent.*;

/**
 * @author : codeking
 * @Date : 2022/9/9 14:25
 *
 * 实现callable接口 这个地方我也用的不熟悉，后续可以在看看其他人的用法是否更加完整
 */
public class ThreadCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "Callable:" + i);
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable callableTest1 = new ThreadCallable();
        ThreadCallable callableTest2 = new ThreadCallable();
        ThreadCallable callableTest3 = new ThreadCallable();

        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> future1 = executorService.submit(callableTest1);
        Future<Boolean> future2 = executorService.submit(callableTest2);
        Future<Boolean> future3 = executorService.submit(callableTest3);

        // 获取结果
        boolean b1 = future1.get();
        boolean b2 = future2.get();
        boolean b3 = future3.get();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // 关闭服务
        executorService.shutdownNow();
    }
}
