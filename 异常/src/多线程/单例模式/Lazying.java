package 多线程.单例模式;

public class Lazying {
    /**
     * 懒汉模式：延时加载方式
     * 需要的时候，才进行初始化（如果不是一开始就需要，就没有一开始就分配资源）
     * 缺点：会使情况变得非常复杂（出现 BUG 的几率变大）
     * 是线程安全的么?  1) 是不是只会有一个对象 2） 对象是否完整无误
     */
    private volatile static Lazying instance = null;

    /*
    //版本一：线程安全，但是效率不高。只需要对instance==null的情况加锁。
    public static synchronized Lazying getInstance(){
        if(instance==null){
            instance =new Lazying();
        }
        return instance;
    }
    */


    // 要点1：二次判断
    // 要点2：instance = new Lazying() 可能会被重排序，引起问题。创建对象时使用volatile。
    public static Lazying getInstance(){
        if(instance==null){
            synchronized (Lazying.class){
                if(instance==null){ // 经过二次判断
                    //instance是静态变量，所以创建对象重排序会出现问题。
                    instance=new Lazying();
                }
            }
        }
        return instance;
    }

    private Lazying(){

    }
}
