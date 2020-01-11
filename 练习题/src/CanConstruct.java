//判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
//通过纪录每个字母的个数来实现
public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //定义一个int型数组，来统计每个字符出现的次数
        int[] num=new int[26];
        for(int i=0;i<magazine.length();i++){
        //从magazine开始 每个字符出现的个数记录在对应下标
            num[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            //如果该字母出现次数为0，则返回false;
            //从ransomNote开始 在managzine中检索
            if(num[ransomNote.charAt(i)-'a']==0){
                return false;
            }
            //否则将该字母可用次数减一
            num[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        String r="aab";
        String m="abca";
        System.out.println(canConstruct(r,m));
    }
}
