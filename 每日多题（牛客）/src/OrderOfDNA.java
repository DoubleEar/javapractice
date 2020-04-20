import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//DNA序列
//给定一个很长的DNA序列，以及要求的最小子序列长度
// 输出G,C总出现次数最高的子序列。
public class OrderOfDNA {
    private static void mostScale(String s,int n) {
        if(s.length()==n)
            System.out.println(s);
        List<char[]> list=new ArrayList<>();
        char[] c=s.toCharArray();
        int max=0;
        for(int i=0;i<c.length-n;i++){
            int count=0;
            char[] arr=new char[n];
            for(int j=0;j<n;j++){
                if(c[j+i]=='G'||c[j+i]=='C'){
                    count++;
                }
                arr[j]=c[j+i];
            }
            if(count>max){
                max=count;
                list.add(arr);
            }
        }
        if(list.size()>0) {
            char[] ch = list.get(list.size() - 1);
            int index = 0;
            StringBuilder sb = new StringBuilder();
            while (index < ch.length) {
                sb.append(ch[index++]);
            }
            System.out.println(sb.toString());
        }
    }

        /*
        private static void mostScale (String s,int n){
            char[] c = s.toCharArray();
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < c.length - n; i++) {
                int count = 0;
                for (int j = i; j < i + n; j++) {
                    if (c[j] == 'G' || c[j] == 'C')
                        count++;
                }
                if (count > max) {
                    maxIndex = i;
                    max = count;
                }
            }

            System.out.println(s.substring(maxIndex, maxIndex + n));
        }
        */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=sc.nextInt();
        mostScale(s, n);
    }
}
