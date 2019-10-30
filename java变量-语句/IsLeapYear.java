import java.util.Scanner;

public class IsLeapYear{
	public static void main(String[] args){
		int year =Integer.parseInt(args[0]);
		if(year % 400 == 0) { 	
			System.out.println("是闰年");
		} else if(year%4==0&&year%100!=0){
				System.out.println("是闰年");
		}else{
				System.out.println("不是闰年"); 
		}
	}
}
			 /*Scanner scanner =new Scanner(System.in);
			 while(scanner.hasNext()){//认空格 \n
				 //scanner.hasNextLine()只认\n
				 String s=scanner.next();
				 System.out.println(s);*/
				 
  


