public class IsLeapYear{
	public static void main(String[] args){
		int year =Integer.parseInt(args[0]);
		if (year%100==0){
			if (year % 400 == 0){
				System.out.println("是闰年");
		}else{
			System.out.println("不是闰年"); 
		}	
		}else{
			if (year % 4 == 0) { 	
			System.out.println("是闰年");
			} else {
			 System.out.println("不是闰年");
			 }
			 } 
	}
}