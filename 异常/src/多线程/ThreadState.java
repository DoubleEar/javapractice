package 多线程;

//观察线程状态的变化。
import java.util.concurrent.TimeUnit;

public class ThreadState {
    private static class AThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    // 1001 ms  1ms 是在执行输出语句，剩下的 1000 ms 都是执行 sleep。
                    // 从概率上来讲 1000/1001 看到的是 TIMED_WAITING；1/1001 看到 RUNNABLE。
                    System.out.println("工作中");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //打印线程所有的状态 State是枚举类型
        Thread.State[] values = Thread.State.values();
        for(Thread.State state:values){
            System.out.print(state+" ");
        }

        AThread a = new AThread();
        System.out.println(a.getState());   // NEW 创建
        a.start();
        System.out.println(a.getState());   // RUNNABLE 运行
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a.getState());   // TIMED_WAITING // 因为刚好 a 线程在执行 sleep
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a.getState());   // TERMINATED 结束
    }
}
