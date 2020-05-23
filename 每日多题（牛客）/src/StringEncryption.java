import java.util.Scanner;
//字符串加解密
public class StringEncryption {
    //加密
    private static char encryption(char c){
            if(c>='0'&&c<='9'){
                if(c=='9')
                    return'0';
                else
                    return (char) (c+1);
            }else if(c>='a'&&c<='z'){
                if(c=='z')
                    return 'A';
                else
                    return (char)(c+1-32);
            }else if(c>='A'&&c<='Z'){
                if(c=='Z')
                    return 'a';
                else
                    return (char)(c+1+32);
            }else
                return c;
        }

        //解密
        private static char decryption(char c){
            if(c>='0'&&c<='9'){
                if(c=='0')
                    return'9';
                else
                    return (char) (c-1);
            }else if(c>='a'&&c<='z'){
                if(c=='a')  //加完密是a必定由Z加密而来
                    return 'Z';
                else
                    return (char)(c-1-32);
            }else if(c>='A'&&c<='Z'){
                if(c=='A')  //加完密是A必定由z加密而来
                    return 'z';
                else
                    return (char)(c+32-1);
            }else
                return c;
        }

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            while (sc.hasNextLine()){
                String s1=sc.nextLine();
                String s2=sc.nextLine();

                //加密后的结果
                char[] c1=s1.toCharArray();
                StringBuilder sb1=new StringBuilder();
                for(int i=0;i<c1.length;i++){
                       sb1.append(encryption(c1[i]));
                }
                System.out.println(sb1.toString());

                //解密后的结果
                char[] c2=s2.toCharArray();
                StringBuilder sb2=new StringBuilder();
                for(int i=0;i<c2.length;i++){
                    sb2.append(decryption(c2[i]));
                }
                System.out.println(sb2.toString());
        }
    }
}
