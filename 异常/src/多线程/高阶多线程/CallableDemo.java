package 多线程.高阶多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//封装成带返回结果的多线程任务
public class CallableDemo {
    static class Counter implements Callable<Integer> {
        private final int count;

        public Counter(int count) {
            this.count = count;
        }

        @Override
        public Integer call() throws Exception {
            int result = 0;
            try {
                for (int i = 1; i <= count; i++) {
                    Thread.sleep(1);
                    result += i;
                }
            } catch (InterruptedException e) {
            }
            return result;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            int count = 5000;

            //利用多线程计算 [1, count] 的总和
            //主线程一直等在子线程计算结束
            //并打印结果
            Callable<Integer> callable = new Counter(count);
            FutureTask<Integer> futureTask = new FutureTask<>(callable);

            Thread thread = new Thread(futureTask);
            thread.start();

            int result = futureTask.get();
            System.out.println(result);
        }
    }
}
