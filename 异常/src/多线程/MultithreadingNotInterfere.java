package 多线程;

public class MultithreadingNotInterfere {
    private static long COUNT = 1_0000_0000L;   // 静态属性，共享的，没修改

    private static class 计算线程 extends Thread {
        @Override
        public void run() {
            long n = 0;     // 有修改的，是局部变量，不共享
            for (int i = 0; i < COUNT; i++) {
                n += i;
            }
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new 计算线程();
        Thread t2 = new 计算线程();
        Thread t3 = new 计算线程();
        Thread t4 = new 计算线程();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
