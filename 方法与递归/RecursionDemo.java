import java.util.Scanner;
public class RecursionDemo{
	public static int sum(int n){
		if(n<10){
			return n;
		}else{
			return sum(n/10)+(n%10);
		}
	}
	/*public static void hanoi(int n,int from,int to){
		if(n==1){
			System.out.printf("从%d移动到%d\n",from,to);
		}else{
			int other=3-from-to;
			hanoi(n-1,from,other);
			System.out.printf("从%d移动到%d\n",from,to);
			hanoi(n-1,other,to);
			//System.out.printf("从%d移动到%d\n",from,to);
		}
	}*/
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		System.out.println(sum(input));
		//hanoi(4,0,2);
	}
}
	
		