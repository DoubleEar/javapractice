package 多线程;

//多线程的优势-->阻塞场景
import java.util.Scanner;

public class MyThread2 {
    //时间复杂度O(2^n)二路递归
    private static long fib(int n){
        if(n>2)
            return n;
        return fib(n-1)+fib(n-2);
    }
    private static class FibThread extends Thread {
        private int n;

        FibThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            System.out.println(fib(n));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            //System.out.println(fib(n));  // 这个是在主线程中直接计算

            // 重新启动一个线程，去计算 fib(n)
            // 主线程负责读取下一个数
            FibThread thread = new FibThread(n);
            thread.start();
        }
    }
}
