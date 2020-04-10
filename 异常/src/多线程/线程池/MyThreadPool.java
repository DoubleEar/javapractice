package 多线程.线程池;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//自己实现线程池
public class MyThreadPool {
    private int nThreads;   // 记录允许创建的最大线程数
    private List<Thread> threads;               // 工作线程
    private BlockingQueue<Runnable> workQueue;  // 任务阻塞队列

    //工作线程
    private static class Worker extends Thread {
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    //从阻塞队列中取任务
                    Runnable target = workQueue.take();
                    target.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //构造方法
    MyThreadPool(int nThreads) {
        this.nThreads = nThreads;

        // 创建阻塞队列
        workQueue = new LinkedBlockingQueue<>();    // 所有线程共享同一个阻塞队列对象

        // 提交创建线程
        threads = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Worker(workQueue);
            thread.start();
            threads.add(thread);
        }
    }

    //将任务加到阻塞队列中
    void execute(Runnable target) throws InterruptedException {
        workQueue.put(target);
    }
}
