package 多线程.单例模式;

public class Main {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            Starving starving=Starving.getInstance();
        }

        public static void main(String[] args) {
            for(int i=0;i<1000;i++){
                new MyThread().start();
            }
        }
    }
}
