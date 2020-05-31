package 多线程.高阶多线程;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

//好像跑步比赛，10个选手依次就位，哨声响才同时出发；所有选手都通过终点，才能公布成绩
public class CountDownLatchDemo {
    private static final int NUMBER=5;
    private static final CountDownLatch cdLatch=new CountDownLatch(NUMBER);

    // Random 其实不是线程安全的
    private static AtomicInteger nextId=new AtomicInteger(1);
    private static Random random=new Random(20200531);

    static class DownLoad extends Thread{
        DownLoad(){
            super(String.format("下载线程(%d)", nextId.getAndIncrement()));
        }

        @Override
        public void run() {
            try{
                TimeUnit.SECONDS.sleep(random.nextInt(8)+2);
                System.out.println(new Date()+":"+getName()+"下载成功");
                cdLatch.countDown();    // 被调用了 NUMBER 次的时候，await() 才会继续执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("一共创建"+NUMBER+"个线程进行下载");
        for(int i=0;i<NUMBER;i++){
            new DownLoad().start();
        }
        // 等着所有的人全部下载成功，才能继续
        cdLatch.await();
        System.out.println("全部下载成功");
    }
}
