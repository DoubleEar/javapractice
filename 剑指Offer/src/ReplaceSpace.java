//用"%20"替换空格
public class ReplaceSpace {
    public static String replaceSpace(String s) {
        /*
        char[] array=new char[s.length()*3];
        int size=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' '){
                array[size++]='%';
                array[size++]='2';
                array[size++]='0';
            }else{
                array[size++]=c;
            }
        }
        String res=new String(array,0,size);
        return res;
        */

        //定义可变的字符数组用于拼接
        StringBuilder stringBuilder=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s="Hello World!";
        System.out.println(replaceSpace(s));
    }
}
