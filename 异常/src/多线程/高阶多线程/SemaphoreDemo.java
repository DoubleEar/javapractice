package 多线程.高阶多线程;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//一个计数信号量，主要用于控制多线程对共同资源库访问的限制。
public class SemaphoreDemo {
    private static final Semaphore semaphore=new Semaphore(4);
    private static final AtomicInteger nextId=new AtomicInteger(1);
    private static final Random random=new Random(20200531);

    static class Player extends Thread{
        Player(){
            super(String.format("大玩家(%d)", nextId.getAndIncrement()));
        }

        @Override
        public void run() {
            try{
                System.out.println(new Date()+":"+getName()+"我要租玩具");
                semaphore.acquire();
                System.out.println(new Date()+":"+getName()+"我租到了玩具");
                TimeUnit.SECONDS.sleep(random.nextInt(5)+5);
                System.out.println(new Date()+":"+"我不玩了，把玩具还回去");
                semaphore.release();    //释放
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Player player=new Player();
            player.start();
        }
    }
}
