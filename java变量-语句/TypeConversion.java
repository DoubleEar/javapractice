public class TypeConversion
{
	public static void main(String args[]){
		int a=10;
		long b=20;
		b=a;
		long f=a+b;
		System.out.println(b);
		System.out.println(f);
		byte c=100;
		byte g=20;
		byte h=(byte)(c+g);
		System.out.println(h);
		System.out.println(c);
		int d=0;
		double e=10.5;
		d=(int)e;
		System.out.println(e);
	}
}
		