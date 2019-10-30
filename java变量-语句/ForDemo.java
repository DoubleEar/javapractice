public class ForDemo{
	public static void main(String[] args){
             int i=1;
			 int j=1; 
			 int sum=0;
			 for(i=1;i<=5;i++){
				 int num=1;
				 for(j=1;j<=i;j++){
					 num*=j;
				 }
				 sum+=num;
			 }
			 System.out.println(sum);
	}
}