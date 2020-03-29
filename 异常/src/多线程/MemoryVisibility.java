package 多线程;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//内存可见性问题
public class MemoryVisibility {
    private volatile static boolean running = true;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (running) {
                n++;
            }
            System.out.println(n);
        }
    }

    /*
    //作为方法修饰符
    public synchronized static void staticMethod(){

    }
    public synchronized void method(){

    }

    //作为代码块
    public void someMethod(){
        Object o=new Object();
        synchronized (o){

        }
    }
    */

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();

        Scanner scanner = new Scanner(System.in);
        System.out.print("随便输入什么，让子线程退出: ");
        scanner.nextLine();

        System.out.println(running);
        running = false;
        System.out.println(running);

        while (true) {
            System.out.println(t.getState());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
