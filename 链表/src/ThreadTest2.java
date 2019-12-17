public class ThreadTest2 {

        public static void main(String[] args) {

            MyThread1  t1=new MyThread1 ();
            MyThread1 t2=new MyThread1 ();
            MyThread1 t3=new MyThread1 ();
            t1.start();
            t2.start();
            t3.start();
        }
    }
    class MyThread1 extends Thread{
        int n=(int)(Math.random()*6000);
        public void run() {
            System.out.println(Thread.currentThread().getName()+' '+n);
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName()+"睡眠结束");
        }
    }

