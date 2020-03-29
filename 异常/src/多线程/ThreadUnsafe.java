package 多线程;

//线程不安全示例——原子性被破坏了。
public class ThreadUnsafe {
    private static long n=0;    //静态属性，共享的。被修改了。
    static class Add extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                n++;
            }
        }
    }

    static class Sub extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                n--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Add add=new Add();
        add.start();
        Sub sub=new Sub();
        sub.start();

        add.join();
        sub.join();

        System.out.println(n);

    }
}
