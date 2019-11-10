class Person{
	String name;
	int age;
	double high;
	
public void sayHello(String target){
	System.out.println(
	name+"say hello to"+target
		);
   }
}
public class Main{
	public static void main(String[] args){
		Person p=new Person();
		p.name="耳耳";
		p.age=20;
		p.high=167.1;
		p.sayHello("早耶");
	}
}