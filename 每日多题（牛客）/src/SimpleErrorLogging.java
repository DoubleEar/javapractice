import java.util.*;
//简单错误记录
public class SimpleErrorLogging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();   //保证输入的顺序性
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s == null || "".equals(s)) break;
            //利用空格分割字符串
            String[] split = s.split("\\s");

            //获得文件名以及代码错误的行数
            String key = split[0].substring(split[0].lastIndexOf('\\') + 1) + " " + split[1];

            //将key加入到map中
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }

        //将map的结果集放入list中，进行比较。
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //按照错误个数进行降序排列
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //输出前八个
        for (int i = 0; i < 8; i ++) {
            //通过空格分割文件名以及错误的代码行数
            String[] split = list.get(i).getKey().split("\\s");

            //判断文件名的长度是否符合要求
            if(split[0].length() > 16) split[0] = split[0].substring(split[0].length() - 16);

            //输出文件名+错误的代码行数+错误的个数
            System.out.println(split[0] + " " + split[1] + " " + list.get(i).getValue());
        }
    }
}
