//空格替换
public class Replacement {
    public static String replaceSpace(String iniString, int length) {
        StringBuilder sb=new StringBuilder();
        char[] c=iniString.toCharArray();
        for(int i=0;i<length;i++){
            if(c[i]==' ')
                sb.append("%20");
            else
                sb.append(c[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("Hello World", 11));
    }
}
