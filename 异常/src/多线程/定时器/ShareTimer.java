package 多线程.定时器;

//共享定时器
public class ShareTimer {
    private static MyTimer myTimer=new MyTimer();

    private static class MyThread extends Thread{
        @Override
        public void run() {
            myTimer.schedule(new MyTimer.MyTimerTask() {
                @Override
                void run() {
                    System.out.println("输出内容");
                }
            },10*1000);
        }

        public static void main(String[] args) {
            for(int i=0;i<10;i++){
                new MyThread().start();
            }
        }
    }
}
