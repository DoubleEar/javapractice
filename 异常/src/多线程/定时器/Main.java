package 多线程.定时器;

import java.util.concurrent.TimeUnit;

public class Main {
    private static class Task extends MyTimer.MyTimerTask{
        @Override
        void run() {
            System.out.println("10s已到！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimer myTimer=new MyTimer();
        myTimer.schedule(new Task(),10*1000);

        while (true){
            System.out.println("自己做自己的事情。");
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
