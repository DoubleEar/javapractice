import java.util.Scanner;
//在霍格沃茨找零钱
public class GetChange {
    private static void getChange(String[] s1,String[] s2){
        int[] weight={29*17,29,1};  //不同单位之间的换算关系。
        int[] P={Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s1[2])};
        int[] A={Integer.parseInt(s2[0]),Integer.parseInt(s2[1]),Integer.parseInt(s2[2])};

        //用 元.角.分 来理解。先把输入的钱换算成最小单位的“分”来表示。
        int tp=P[0]*weight[0]+P[1]*weight[1]+P[2]*weight[2];
        int ta=A[0]*weight[0]+A[1]*weight[1]+A[2]*weight[2];

        //相减获得结果（以“分”为单位）
        int res=ta-tp;
        if(ta<tp){
            System.out.print("-");
            res=-res;
        }

        //再将结果还原为 元.角.分 的形式。
        System.out.println(res/weight[0]+"."+res%weight[0]/weight[1]+"."+
                            res%weight[0]%weight[1]/weight[2]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();

            String[] str1=s1.split("\\.");
            String[] str2=s2.split("\\.");

            getChange(str1,str2);
        }
    }
}
