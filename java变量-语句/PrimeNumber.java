// 判定一个数字是否是素数
///打印 1 - 100 之间所有的素数 
public class PrimeNumber{
	public static void main(String[] args){
		//int input=Integer.parseInt(args[0]);
		boolean flag=true;
		for(int i=1;i<=100;i++){
			for(int j=2;j<=i;j++){
			/*if(input%i==0&&i!=input){
				System.out.println("不是素数");
				break;
			}
			else if(i==input){
				System.out.println("是素数");
				break;
			}
		}*/
		if(i%j==0){
			flag=false;
			break;
			}
		}
		if(flag){
			System.out.println("i");
		}
	}
}
}