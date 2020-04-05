package 多线程.阻塞队列.单生产者单消费者;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static CircleQueue queue = new CircleQueue();

    private static class producer extends Thread {
        producer() {
            super("生产者");
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    System.out.print("请输入下一个数字: ");
                    int element = scanner.nextInt();
                    queue.put(element);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class consumer extends Thread {
        consumer() {
            super("消费者");
        }

        @Override
        public void run() {
            Random random = new Random(20200405);
            try {
                while (true) {
                    int element = queue.take();
                    System.out.println("消费者读出: " + element);
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        producer p = new producer();
        p.start();
        consumer c = new consumer();
        c.start();
    }
}

