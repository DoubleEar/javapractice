public class Test {
	public static void main(String[] args) {
		Rectangle r=new Rectangle(3,4);
		System.out.println(r.area());
		Circle c=new Circle(2.0);
		System.out.println(c.area());
		Calculate s=new Calculate();
        System.out.println(s.cal(r));
		System.out.println(s.cal(c));
    }
}

