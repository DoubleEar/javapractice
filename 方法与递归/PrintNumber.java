//按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) 
import java.util.Scanner;
public class PrintNumber{
	public static void PrintNumber(int a){
		if(a<10){
			System.out.println (a);
		}else{
			PrintNumber(a/10);
			System.out.println (a%10);
	}
}
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		PrintNumber(input);
	}
}
		
		