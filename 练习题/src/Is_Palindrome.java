//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
public class Is_Palindrome {
    public static boolean isPalindrome(String s) {
        char res;
        char[] ch=s.toCharArray();
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            //判断是否是字符或者数字
            boolean flag1=(ch[i]>='0'&&ch[i]<='9'||ch[i]>='a'&&ch[i]<='z'||ch[i]>='A'&&ch[i]<='Z');
            boolean flag2=(ch[j]>='0'&&ch[j]<='9'||ch[j]>='a'&&ch[j]<='z'||ch[j]>='A'&&ch[j]<='Z');
            //如果首为假尾为真，将尾的数组下标保持不变，首的数组下标加一
            if(!flag1&&flag2){
                j++;
            }
            //如果尾为假首为真，将首的数组下标保持不变，尾的数组下标减一
            if(flag1&&!flag2){
                i--;
            }
            //如果首尾都为字符或者数字则首尾交换
            if(flag1&&flag2){
                res=ch[j];
                ch[j]=ch[i];
                ch[i]=res;
            }
        }
        return s.equalsIgnoreCase(String.valueOf(ch));
    }
    public static void main(String[] args) {
        //String s1="A man, a plan, a canal: Panama";
        String s2="race a car";
        //System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
}
