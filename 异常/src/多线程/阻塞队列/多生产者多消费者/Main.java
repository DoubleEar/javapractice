package 多线程.阻塞队列.多生产者多消费者;

import java.util.Random;

public class Main {
    private static CircleQueue queue = new CircleQueue();

    private static class producer extends Thread {
        producer() {
            super("生产者");
        }

        @Override
        public void run() {
            Random random = new Random(20200405);
            try {
                while (true) {
                    queue.put(random.nextInt(200));
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
            try {
                while (true) {
                    queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new producer().start();
        }

        for (int i = 0; i <10; i++) {
            new consumer().start();
        }
    }
}
