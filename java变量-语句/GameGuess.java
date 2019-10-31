import java.util.Random;
import java.util.Scanner;
public class GameGuess{
	public static void main(String[] args){
		Random random=new Random();
		Scanner scanner=new Scanner(System.in);
		System.out.println("欢迎进入游戏，数字正在生成中");
		int n=random.nextInt(100);
		System.out.println("请输入你要猜的数字");
		int times=6;
		System.out.println("你有"+times+"次机会");
		for(int i=1;i<=times;i++){
			int x=scanner.nextInt();
			if(x==n){
				System.out.println("成功了，用了"+times+"次机会");
				return;
			}else if(x<n){
				System.out.println("第"+i+"次猜测，你的数字猜小了");
			}else{
				System.out.println("第"+i+"次猜测，你的数字猜大了");
			}
		}
		System.out.println("很遗憾，GameOver!");
		System.out.println("数字其实是"+n);
	}
}
				
				
		