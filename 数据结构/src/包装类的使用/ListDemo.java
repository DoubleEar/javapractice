package 包装类的使用;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("C语言");
        list.add("java");
        list.add("数据结构");
        list.add("python");
        List<String> list2=new ArrayList<>();
        //尾插list中的元素
        list2.add("数据库");
        list2.addAll(list);
        for(String e:list2){
            System.out.println(e);
        }
        list.remove(0);
        list.remove("C语言");
        for(String e:list){
            System.out.println(e);
        }

        list.set(1,"计算机基础");
        System.out.println(list.get(1));

        System.out.println(list2.contains("数据库"));

        //返回第一个o所在的下标
        int i=list.indexOf("java");
        System.out.println(i);
        //截取部分 [1, 3)
        List<String> sublist=list.subList(1,3);
        for(String e:sublist){
            System.out.println(e);
        }
        System.out.println("--------------");
       //用构造方法实现全部拷贝
        List<String> list3 = new ArrayList<>(list);
        System.out.println(list);


    }
}
