import java.util.*;
//大整数的比较
public class BigIntSort {
    static class BigInteger implements Comparable<BigInteger> {
        private String s;

        public BigInteger(String s){
            this.s=s;
        }

        @Override
        public int compareTo(BigInteger o) {
            //1.先比较长度
            if(s.length()<o.s.length())
                return -1;
            else if(s.length()>o.s.length())
                return 1;
            else
                //2.字符串比较
                return s.compareTo(o.s);
        }

        public String getS(){
            return s;
        }
    }
    private static void mySort(String[] s, int n) {
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(s[i].length()>s[j].length()){
                    String temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;
                }else if(s[i].length()==s[j].length()){
                    if(s[i].compareTo(s[j])>0){
                        String temp=s[i];
                        s[i]=s[j];
                        s[j]=temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            sc.nextLine();

            /*
            String[] s=new String[n];
            for(int i=0;i<n;i++){
                s[i]=sc.next();
            }

            mySort(s,n);

            for(String str:s){
                System.out.println(str);
            }
            */


            Map<BigInteger, String> map = new TreeMap<>();
            for(int i=0;i<n;i++){
                map.put(new BigInteger(sc.nextLine()),null);
            }

            Set<BigInteger> set=map.keySet();
            for(BigInteger key:set){
                System.out.println(key.getS());
            }
        }
    }
}
