public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int i=0;
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)!=' '){
                i++;
                continue;
            }
            if(i>0)
                return i;
        }
        return i;
    }

    public static void main(String[] args) {
        String s1="Hello World";
        String s2="Welcome to xianyang";
        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
    }
}
