import java.util.Arrays;
import java.util.Scanner;
public class ArrayPractice{
	/*
	 * 进行数组的复制，返回一个新的数组，数组长度是 newLength
	 * 如果 newLength <= 原数组长度的，进行截取
	 * 如果 newLength > 原数组长度, 其余位置用 0 填充
	 */
	public static int[] copyOf(int[] a, int newLength) {
		int[] dest = new int[newLength];
		// dest 现在的元素值是多少	0
		// int length = newLength < a.length ? newLength : a.length;
		int length = Math.min(newLength, a.length);
		for (int i = 0; i < length; i++) {
			dest[i] = a[i];
		}
		
		return dest;
	}
	
	public static int[] copyOfRange(int[] a, int from, int to) {
		int[] dest = new int[to - from];
		for (int i = from; i < to; i++) {
			dest[i - from] = a[i];
		}
		
		return dest;
	}
	public static int[] arraycopy(int [] src,int srcPos,int [] dest,int destPos,int length){
		if (src == dest) {
			int[] tmpArray = copyOfRange(src, srcPos, srcPos + length);
			for (int i = 0; i < length; i++) {
				dest[destPos + i] = tmpArray[i];
			}
		} else {
			for (int i = 0; i < length; i++) {
				dest[destPos + i] = src[srcPos + i];
			}
		}
		return dest;
	}	

	public static void main(String[] args){
		int[] a = {1,9,6,7,7};
		int[] b = {1,3,5,2,6};
		int[] c = arraycopy(a,1,b,3,2);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(copyOfRange(a,1,4)));
		System.out.println(Arrays.toString(copyOf(a,7)));
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		