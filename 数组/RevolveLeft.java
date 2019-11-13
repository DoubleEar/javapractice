import java.util.Arrays;
class RevolveLeft{
	//{1,2,3,4,5}  2   {3,4,5,1,2}
	public static int[] Spin(int [] a,int n){
		int[] b=new int[a.length];
		int i=0;
		if(n>a.length)
		{
			n%=a.length;
		}
		for(i=0;i<a.length-n;i++){
			b[i]=a[i+n];
		}
		for(i=a.length-n;i<a.length;i++){
			b[i]=a[i+n-a.length];
		}
		return b;
	}
	public static void main(String[] args){
		int[] a={1,2,3,4,5};
		int[] c=Spin(a,4);
		System.out.println(Arrays.toString(c));
	}
}