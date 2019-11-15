public class Calculator{
	//一个类Calculator,有两个属性num1,num2,实现加减乘除。
		double num1;
		double num2;
		Calculator(int num1,int num2){
			this.num1=num1;
			this.num2=num2;
		}
		
		
		Calculator(double num1,int num2){
			this.num1=num1;
			this.num2=num2;
		}
		
		
		Calculator(double num1,double num2){
			this.num1=num1;
			this.num2=num2;
		}
		
		
		double Add(){
			return num1+num2;
		}
		
		
		double Minus(){
			return num1-num2;
		}
		
		double Multiply(){
			return num1*num2;
		}
		
		double Division(){
			return num1/num2;
		}
	public static void main(String[] args){
		Calculator c1=new Calculator(5,6);
		Calculator c2=new Calculator(5.1,4);
		Calculator c3=new Calculator(5.4,0.6);
		System.out.println(c1.Add());
		System.out.println(c2.Minus());
		System.out.println(c1.Multiply());
		System.out.println(c3.Division());
	}
}