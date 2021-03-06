package net.tanpeng.java.concurrent;

import java.util.concurrent.*;

/**
 * 为任务设置时限，超过这个时间就抛弃
 */
public class CallableFutureWithTimeout {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletionService completionService = new ExecutorCompletionService(executor);

        Future future = completionService.submit(() -> 1);

        // 第一个参数是 timeout的时间，第二个是单位
        Object result = future.get(10000, TimeUnit.SECONDS);
        System.out.println(result);
    }
}
