public class ThreadTest {
    public static void main(String[] args) {
        MyThread r =new MyThread();
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
class MyThread implements Runnable{
    int n=(int)(Math.random()*6000);
    public void run() {
        System.out.println(Thread.currentThread().getName()+' '+n);
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName()+"睡眠结束");
    }
}
