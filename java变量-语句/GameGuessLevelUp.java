import java.util.Random;
import java.util.Scanner;
public class GameGuessLevelUp{
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎进入游戏，数字正在生成中");
        System.out.println("请输入你要挑战的级别,1代表低级,2代表中极,3代表高级");
        int input = scanner.nextInt();
        int temp = 0;
        int times = 0;
        int n = random.nextInt(100);//随机数n
        //System.out.println(n);
        switch (input) {
            case 1:
                times = 15;
                game(times,n);
                break;
            case 2:
                times= 10;
                game(times,n);
                break;
            case 3:
                times = 5;
                game(times,n);
                break;
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }
    }
        static void game(int times,int n)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要猜的数字");
            System.out.println("你有"+times+"次机会");
            for(int i=1;i<=times;i++){
                int input=scanner.nextInt();
                if(input==n){
                    System.out.println("成功了，用了"+i+"次机会");
                    return;
                }else if(input < n){
                    System.out.println("第"+i+"次猜测，你的数字猜小了");
                }else{
                    System.out.println("第"+i+"次猜测，你的数字猜大了");
                }
            }
            System.out.println("很遗憾，GameOver!");
            System.out.println("数字其实是"+n);
        }
    }