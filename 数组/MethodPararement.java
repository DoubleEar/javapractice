import java.util.Scanner;
import java.util.Arrays;
public class MethodPararement{
	public static void swap(int [] a,int i,int j){
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void bubbleSort(int [] a){
		//需要多少次冒泡的过程
		for(int i=0;i<a.length-1;i++){
			//实心箭头的循环范围
			for(int j=0;j<a.length-i-1;j++){
			if(a[j]>a[j+1]){
				swap(a,j,j+1);
			 }
		  }
		}
	}
	/*public static int binarySearch(int [] a,int x){
		while(left<=right){
			int left=0;
			int right=a.length-1;
			int mid=(left+right)/2;
			if(x==a[mid]){
			return mid;
		}else if(x>a[mid]){
			left=mid+1;
		}else{
			right=mid-1;
		}	
	 }
	return -1;
	}*/
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int[]a = new int[5];
		for(int i=0;i<5;i++){
			a[i]=scanner.nextInt();
		}
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
		/*int [] a={1,2,3,4};
		int ret=binarySearch(a,4);
		System.out.println(ret);*/
	}
}
	
	
	
	
	
	
	
	
	
	