import java.util.Arrays;
public class ArrayDemo{
	/*public static int[] creatArray(int n){
		return new int[n];
	}*/
	/*public static void printArray(int[] a){
			int size=a.length;
			for(int i=0;i<size;i++){
			System.out.println(a[i]);
			}
	}*/
	public static int max(int[] a){
		int max=a[0];
		for(int i=0;i<a.length;i++){
			if(a[i]>max){
				max=a[i];
				}
			}
			return max;
		}
	public static double average(int[] a){
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			}
			return (double)sum/a.length;
	}
	public static int indexOf(int[] a,int x){
		for(int i=0;i<a.length;i++){
			if(a[i]==x)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(int[] a,int x){
		for(int i=a.length-1;i>=0;i--){
			if(a[i]==x)
			return i;
		}
			return -1;
	}	
	public static int[] copyOfRange(int[] a,int from,int to){
		int[] b=new int[to-from];
		for(int i=from;i<to;i++){
			b[i-from]=a[i];
		}
		return b;
	}
		
	public static void main(String[] args){
		//int[] a =creatArray(10);
		//printArray(a);
		int[] a={1,2,5,7,3,9,5};
		//int b=5;
		System.out.println(max(a));
		System.out.println(average(a));
		//System.out.println(indexOf(a,b));
		//System.out.println(lastIndexOf(a,b));
		int[] n=copyOfRange(a,1,4);
		System.out.println(Arrays.toString(n));
		
	}

}
	