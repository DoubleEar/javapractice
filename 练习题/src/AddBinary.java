//给定两个二进制字符串，返回他们的和（用二进制表示）。
public class AddBinary {
    public static String addBinary(String a, String b) {
        int len1=a.length();
        int len2=b.length();
        if(len1<len2)
            return addBinary(b,a);
        int[] result=new int[len1+1];
        int index=len1-1;
        int j=len2-1;
        while(index>=0){
            int tmp=j>=0?(a.charAt(index)-'0')+(b.charAt(j)-'0')+result[index+1]
                    :(a.charAt(index)-'0'+result[index+1]);
            result[index+1]=tmp%2;
            result[index]+=tmp/2;
            index--;
            j--;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<result.length;i++){
            if(i==0&&result[i]==0)
                continue;
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a="0001";
        String b="11";
        System.out.println(addBinary(a,b));
    }
}
