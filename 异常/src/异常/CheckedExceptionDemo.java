package 异常;

public class CheckedExceptionDemo {
    //受查异常
    private static void method() throws Exception{
        System.out.println("Hello World");
    }
    //第一种方法抛出异常
    /*
    public static void main(String[] args) throws Exception {
        method();
    }
    */
    //第二种方法catch掉所有异常
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
