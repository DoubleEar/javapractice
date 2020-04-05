package 多线程.定时器;

//自己实现定时器
//缺点：每一次使用定时器就创建一个新的线程
public class MyTimer {
    static abstract class MyTimerTask {
        abstract void run();
    }

    void schedule(MyTimerTask task, long delay) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                    //执行自定义的run方法
                    task.run();
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}
