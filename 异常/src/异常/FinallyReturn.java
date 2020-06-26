package 异常;

public class FinallyReturn {
    //无论怎样都要执行
    private static int method(){
        try{
            System.out.println("1");
            throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("2");
            return 20;
        }finally {
            System.out.println("3");
            return 30;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
