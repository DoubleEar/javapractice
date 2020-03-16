import java.util.*;
//给一非空的单词列表，返回前 k 个出现次数最多的单词。
public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            //如果表中已有key就将key的value加1。
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //创建最小堆
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                //当两个单词出现的次数一样时，按字典序排序（String）。
                if(map.get(o1)==map.get(o2))
                    //按字典序降序排列排列。
                    //因为后面进行的头插工作，所以要先拿到字典序大的字符串。
                    return o2.compareTo(o1);
                //默认最小堆
                return map.get(o1)-map.get(o2);
            }
        });

        //只保留前K个数
        for(String key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                //出队列操作，将堆顶最小元素删除。
                pq.poll();
            }
        }

        //头插
        LinkedList<String> list=new LinkedList<>();
        while (!pq.isEmpty()){
            list.addFirst(pq.poll());
        }

        /*
        //将所有元素插入优先队列中。获取所有key组成的set集合。
        for(String key:map.keySet()){
            pq.add(key);
        }

        //将前k个元素加入到list中
        List<String> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.poll());
        }
        */
        return list;
    }

    public static void main(String[] args) {
        String[] words={"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words,2));
    }
}
