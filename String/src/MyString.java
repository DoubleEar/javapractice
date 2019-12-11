import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//String对象不可变性，常量池入池
public final class MyString {
    //不是真正的常量池，只是利用静态属性模拟常量池
    private static List<MyString> constantPool=new ArrayList<>();
    private final char[] value;
    private final int length;

    public MyString(char[] value){
        this.value= Arrays.copyOf(value,value.length);
        this.length=value.length;
    }
    //"hello"+"world"=>"helloworld"
    public MyString concat(MyString s){
        char[] v=new char[length+s.length];
        System.arraycopy(value,0,v,0,length);
        System.arraycopy(s.value,0,v,length,s.length);
        return new MyString(v);
    }

    public char[] toCharArray(){
        return Arrays.copyOf(value,length);
    }

    //判断池中是否有相同对象
    public MyString intern(){
        for(MyString s:constantPool){
            if(s.equals(this)){
                return  s;
            }
        }
        constantPool.add(this);
        return this;
    }

    public static void main(String[] args) {
        char[] c={'h','e','l','l','o'};
        MyString string1 =new MyString(c);
        char[] s={' ','w','o','r','l','d'};
        MyString string2=new MyString(s);
        System.out.println(string1.concat(string2).toCharArray());
        System.out.println(string1.toCharArray());
        System.out.println(string2.toCharArray());
        System.out.println(string1.intern().toCharArray());
    }

}
