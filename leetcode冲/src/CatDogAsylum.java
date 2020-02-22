import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//猫狗收容所
public class CatDogAsylum {
    public static ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> res = new ArrayList<>();
        if (ope == null || ope.length == 0 || ope[0] == null || ope[0].length == 0)
            return res;
        Queue<Integer> cat = new LinkedList<>();
        Queue<Integer> dog = new LinkedList<>();
        Queue<Integer> all = new LinkedList<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {//有动物进收养所
                if (ope[i][1] > 0) {    //是狗
                    dog.add(ope[i][1]);
                    all.add(ope[i][1]);
                } else if (ope[i][1] < 0) {  //是猫
                    cat.add(ope[i][1]);
                    all.add(ope[i][1]);
                }
            } else if (ope[i][0] == 2) { //有人收养宠物
                if (ope[i][1] == 0) {   //第一种收养方式
                    if (!all.isEmpty()) {
                        int tmp = all.poll();
                        res.add(tmp);
                        if (tmp > 0) {  //默认收养了狗
                            dog.poll();
                        } else { //默认收养了猫
                            cat.poll();
                        }
                    }
                } else if (ope[i][1] == 1) { //指定收养狗
                    if (!dog.isEmpty()) {
                        int tmp = dog.poll();
                        res.add(tmp);
                        all.remove(tmp);
                    }
                } else if (ope[i][1] == -1) {   //指定收养猫
                    if (!cat.isEmpty()) {
                        int tmp = cat.poll();
                        res.add(tmp);
                        all.remove(tmp);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ope={{1,1},{1,-1},{2,0},{2,-1}};
        System.out.println(asylum(ope));
    }
}
