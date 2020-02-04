//编写一个函数来查找字符串数组中的最长公共前缀。
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        //以第一个字符串作为基准进行判断
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                //当i等于之后的字符串长度或者两字符不同时
                if(i==strs[j].length()||strs[j].charAt(i)!=c)
                    //重新返回数组，从0号下标开始到i下标结束
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs={"float","flow","flower"};
        System.out.println(longestCommonPrefix(strs));
    }
}
