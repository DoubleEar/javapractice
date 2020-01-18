//其中一些字符可能被长按，那么就返回 True。
public class IsLongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        char[] c1=name.toCharArray();
        char[] c2=typed.toCharArray();
        int p1=0;
        int p2=0;
        while(p1<c1.length&&p2<c2.length){
        //如果两个字符相等p1、p2都加一
            if(c1[p1]==c2[p2]){
                p1++;
            }
        //两个字符不相等则p2加一
            p2++;
        }
        //判断name的长度是否等于p1的长度
        return p1==c1.length;
    }

    public static void main(String[] args) {
        String name="aabcd";
        String typed="abcdd";
        System.out.println(isLongPressedName(name,typed));
    }
}
