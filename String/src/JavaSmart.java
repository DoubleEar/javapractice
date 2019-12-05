public class JavaSmart {
    public static void main(String[] args) {
        String s="Hello";
        s=s+" ";
        s=s+"World";
        System.out.println(s);

        System.out.println("abc".compareTo("bbc")); // < 0
        System.out.println("abc".compareTo("abcd")); // < 0
        System.out.println("abc".compareTo("bbcd")); // < 0
        System.out.println("bbcd".compareTo("abc")); // > 0

    }
}
