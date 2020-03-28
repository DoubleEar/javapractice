package 多线程;

//观察yield方法的功能。
public class Yield {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("其他的线程");
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();//new MyThread()  才是真正创建对象的语句
        myThread.start();

        while (true){
            System.out.println("你好");
            //yield方法主动放弃CPU，但是没有放弃抢占CPU的资格。
            //即从运行到就绪—>运行—>就绪—>运行—>就绪
            Thread.yield();
        }
    }
}
