import java.util.Arrays;
public class ArrayFill {
public static void fill1(int[] a, int val) {
		for (int i = 0; i < a.length; i++) {
			a[i] = val;
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void fill2(int[] a, int from, int to, int val) {
		for (int i = from; i < to; i++) {
			a[i] = val;
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static boolean equals(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		int []a={1,2,5,6,8};
		int []b={2,4,5,8,9};
		fill1(a,0);
		fill2(b,2,4,1);
		System.out.println(equals(a,b));

	}
}
		
		
		
		
		
		
		
		
		