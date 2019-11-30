package 接口;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        //HashMap是无序的
        Map<String,String>map=new HashMap<>();
        map.put("作者","耳耳");//插入
        map.put("标题","白日梦想家");//插入
        map.put("发表时间","2019");//插入
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()
                        +"--->"+entry.getValue());
        }
        map.put("标题","实现者");//修改
        map.put("发表时间","2020");//修改
        map.put("页数","1000");//插入
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()
                    +"--->"+entry.getValue());
        }
        //根据指定的 k 查找对应的 v，没有找到用默认值代替
        System.out.println(map.getOrDefault("出版社",
                "长江出版社"));
        System.out.println(map.containsKey("标题"));
        System.out.println(map.containsValue("耳耳"));
        System.out.println(map.containsValue("大白鹅"));
        //根据指定的 k 查找对应的 v
        System.out.println(map.get("作者"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
