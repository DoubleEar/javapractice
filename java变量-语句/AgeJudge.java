//根据年龄, 打印少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上) 
public class AgeJudge{
	public static void main(String[] args){
		int input=Integer.parseInt(args[0]);
		if(input!=0&&input<=18){
			System.out.println("少年");
		}
			else if(input>=19&&input<=28){
				System.out.println("青年");
			}
				else if(input>=29&&input<=55){
					System.out.println("中年");
				}
					else if(input>=56){
					System.out.println("老年");
				}
	}
}
					
	