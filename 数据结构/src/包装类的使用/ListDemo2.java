package 包装类的使用;


import java.util.ArrayList;
import java.util.List;

class Student{
    private int number=0;
    private String name=null;
    private int id=0;

    public Student(int number,String name,int id){
        this.number=number;
        this.name=name;
        this.id=id;
    }

    //原来的equals比较的是引用，看是否指向同一片空间
    @Override
    public boolean equals(Object obj) {
        //空引用
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        Student s=(Student) obj;
        return number==s.number;
    }
}
public class ListDemo2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "耳耳", 1));
        list.add(new Student(11, "朋友", 12));
        list.add(new Student(12, "爱民", 3));
        list.add(new Student(13, "耳耳", 5));
        list.add(new Student(14, "小伙", 76));
        list.add(new Student(15, "女孩", 10));
        System.out.println(list.size());  //6
        Student stu = new Student(10, "耳耳", 1);
        list.remove(stu);
        System.out.println(list.size());  //5

        List<String> list2 =new ArrayList<>();
        list2.add(new String("1"));
        System.out.println(list2.size());  // 1
        list2.remove(new String("1"));
        System.out.println(list2.size());  // 0
    }
}
