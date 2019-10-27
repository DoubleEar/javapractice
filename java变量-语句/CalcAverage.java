public class CalcAverage{
	public static void main(String[] args){
		if(args.length==0){
			System.out.println("至少输入一个数");
			return;
		}
		int sum =0;
		for(int i = 0;i<args.length;i++){
		 sum+=Integer.parseInt(args[i]);
		 }
		 double average =sum*1.0/args.length;
		 System.out.println("平均值是："+average);
	}
}
		 