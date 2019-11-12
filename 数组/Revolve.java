import java.util.Arrays;
class Revolve{
	//数组的右旋 a{1,2,3,4,5}   2    b{4,5,1,2,3}
	public static int[] spin(int[]a,int n){
		int[] b=new int[a.length];
		if(n>a.length)
		{
			n=n-a.length;
		}
		for(int i=0;i<a.length-n;i++){
			b[i+n]=a[i];
		}
		for(int i=a.length-n;i<a.length;i++){
			b[i+n-a.length]=a[i];
		}
		return b;
	}
	public static void main(String[] args){
		int []a={1,2,3,4,5};
		int []c=spin(a,8);
		System.out.println(Arrays.toString(c));
	}
}