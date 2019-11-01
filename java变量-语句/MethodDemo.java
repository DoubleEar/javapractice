import java.util.Scanner;
/*public class Sub{
public static double Sub(double a,double b){
	double r=a-b;
	return r;
}
	public static void main(String[] args){
		int a=5;
		int b=1;
		double r=Sub(a,b);
		System.out.println(r);
	}
}*/
 /*class MethodDemo{
	 public static void main(String[] args){
		int sum=0;
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		//scannerLine();
		for(int i=1;i<=n;i++){
			sum+=factorial(i);
		}
	    System.out.println(sum);
	   }
	
	public static int factorial(int n){
		int ret=1;
		int i=1;
		for(i=1;i<=n;i++){
			ret*=i;
		}
			return ret;
	    }
 }*/
 /*class MethodDemo{
	 public static void main(String[] args){
		 Scanner scanner=new Scanner(System.in);
		 int i=scanner.nextInt();
		 long ret=fac(i);
		 System.out.println(ret);
	 }
		 public static long fac(int n){
			 if(n==1){
				 return 1;
			 }else{
				return n*fac(n-1);
			 }
		 }
	 }*/
 
	class MethodDemo{
	 public static void main(String[] args){
		 Scanner scanner=new Scanner(System.in);
		 int i=scanner.nextInt();
		 long ret=fib(i);
		 System.out.println(ret);
	 }
	  public static long fib(int n){
			 if(n==1||n==2){
				 return 1;
			 }else{
				 return fib(n-1)+fib(n-2);
			 }
		 }
	}
		 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
		