/*public class RecursionAdd{
		public static int Add(int[] x){
			int sum=0;
		    for(int v:x){
				sum+=v;
			}
			return sum;
	}
	public static void main(String[] args){
		int [] a={1,2,3,4,5,6,7,8,9,10};
		int sum=Add(a);
		System.out.println(sum);
	}
}*/
public class RecursionAdd{
	public static int Add(int x){
		if(x==1){
			return 1;
		}else{
		return Add(x-1)+x;
		}
	}
	public static void main(String[] args){
		int num=10;
		System.out.println(Add(num));
	}
	}
	