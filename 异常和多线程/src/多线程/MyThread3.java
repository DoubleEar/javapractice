package 多线程;

//两种方法实现多线程。
public class MyThread3 {
    /*
    //实现Runnable接口
    static class MyRunnable implements Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        MyRunnable mr1=new MyRunnable();
        MyRunnable mr2=new MyRunnable();
        MyRunnable mr3=new MyRunnable();


        // 最终线程需要有线程对象
        Thread t1=new Thread(mr1);
        Thread t2=new Thread(mr3);
        Thread t3=new Thread(mr3);
        Thread t4=new Thread(mr2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    */

    //继承Thread类
    static class MyThread extends Thread{
        @Override
        public void run() {
        }
    }

    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();

        // t1 和 t2 这两个引用指向了各自的线程对象
        // 线程最终要执行是 run 方法中的代码
        t1.start();
        t2.start();
    }
}
