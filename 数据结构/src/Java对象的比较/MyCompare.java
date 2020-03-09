package Java对象的比较;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyCompare {

}
/*
自定义类型进行比较
    1.实现Comparable中的compareTo方法   ---->自然排序的实现方式
    2.实现比较器Comparator中compare方法（和类不在一起） ---->非自然排序的实现方式
 */

//实现Comparable接口完成比较
//class person{
class person implements Comparable<person>{
    public String name;
    public int age;
    public String gender;
    public String ID;

    public person(String name,int age,String gender,String id){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.ID=id;
    }

    //覆写Comparable中的compareTo方法。
    @Override
    public int compareTo(person o) {
        int ret=age-o.age;
        if(ret<0)
            return -1;
        else if(ret>0)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+gender+" "+ID;
    }
}

class personAgeComparator implements Comparator<person>{

    @Override
    public int compare(person o1, person o2) {
        int ret=o1.age-o2.age;
        if(ret<0)
            return -1;
        else if(ret==0)
            return 0;
        else
            return 1;
    }
}

class personIdComparator implements Comparator<person>{
    //Strin按照字典序的类型比较，与长度无关
    @Override
    public int compare(person o1, person o2) {
        return o1.compareTo(o2);
    }
}
class test1{
    public static void main(String[] args) {
        int[] arr={5,3,8,10,9};
        person[] personArr={new person("耳耳",20,"女","17050411123"),
                            new person("早耶",21,"女","17050411103"),
                            new person("大白鹅",19,"男","17050411146")};
        Arrays.sort(arr);
        //person已经实现Comparable中的compareTo方法
        Arrays.sort(personArr);
        System.out.println(Arrays.toString(personArr));
        //已经有了person类型比较器
        Arrays.sort(personArr,new personAgeComparator());
        System.out.println("年龄的比较：");
        System.out.println(Arrays.toString(personArr));

        Arrays.sort(personArr,new personIdComparator());
        System.out.println("ID的比较：");
        System.out.println(Arrays.toString(personArr));
    }
}

//自定义比较器，自定义比较规则，大堆。
class IntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
class test2{
    public static void main(String[] args) {
        //PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(new IntegerComparator());
        pq.offer(4);
        pq.offer(7);
        pq.offer(0);
        pq.offer(3);
        pq.offer(9);
        pq.offer(-1);

        while (!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
    }
}
