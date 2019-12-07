import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMethod {
    //找出所有和String s相等的
    public static List<String>finalEqual(List<String> origin,String s){
        List<String> result=new ArrayList<>();
        for(String s1:origin){
            if(s1.equals(s))
                result.add(s1);
        }
        return result;
    }

    //小于String s
    public static List<String> finalessThan(List<String> origin,String s){
        List<String> result=new ArrayList<>();
        for(String s1:origin){
            if(s1.compareTo(s)==-1)
                result.add(s1);
        }
        return result;
    }

    //不区分大小写比较两个字符串
    public static List<String> finalEqualIgnoreCaseList(List<String> origin,String s){
       List<String> result=new ArrayList<>();
        for(String s1:origin) {
            if(s1.equalsIgnoreCase(s)){
                result.add(s1);
            }
        }
        return result;
    }

    //返回s结尾的字符串
    public static List<String> finalEndWith(List<String> origin,String s){
        List<String> result=new ArrayList<>();
        for(String s1:origin) {
            if(s1.endsWith(s)){
                result.add(s1);
            }
        }
        return result;
    }

    //返回包含s的字符串
    public static List<String> finalContains(List<String> origin,String s){
        List<String> result=new ArrayList<>();
        for(String s1:origin) {
            if(s1.contains(s)){
                result.add(s1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> origin=new ArrayList<>();
        origin.add("abcdef");
        String s1="abcdef";
        String s2="bbcdes";
        String s3="Abcdef";
        String s4="def";
        System.out.println(finalEqual(origin,s1));
        System.out.println(finalessThan(origin,s2));
        System.out.println(finalEqualIgnoreCaseList(origin,s3));
        System.out.println(finalEndWith(origin,s4));
        System.out.println(finalContains(origin, s4));

        //分割字符串
        String domain="www.baidu.com";
        String[]subdomain=domain.split("\\.");
        System.out.println(Arrays.toString(subdomain));

        //拼接字符串
        String[] s={"www","baidu","com"};
        String result=String.join(".",s);
        System.out.println(result);

        //字符串连接
        String s5="hello";
        String s6=" world";
        String s7=s5.concat(s6);
        System.out.println(s7);


    }
}
