import java.util.*;

public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            //如果表中已有key就将key的value加1。
            map.put(word,map.getOrDefault(word,0)+1);
        }

        //优先队列实现比较器
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            //重写compare方法。
            @Override
            public int compare(String o1, String o2) {
                //当两个单词出现的次数一样时，按字典序排序（String）。
                if(map.get(o1)==map.get(o2))
                    return o1.compareTo(o2);
                //按照降序排列
                return map.get(o2)-map.get(o1);
            }
        });

        //将所有元素插入优先队列中。获取所有key组成的set集合。
        for(String key:map.keySet()){
            pq.add(key);
        }

        //将前k个元素加入到list中
        List<String> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words={"the", "day", "is", "sunny", "the",
                        "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words,4));
    }
}
