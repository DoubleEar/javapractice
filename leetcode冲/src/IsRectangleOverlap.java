//矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
//判断两个矩形是否重叠。
public class IsRectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
        return !(rec1[2]<=rec2[0]|| //左（1最右边小于2最左边）
                rec1[0]>=rec2[2]||  //右（1最左边大于2最右边）
                rec1[1]>=rec2[3]||  //上（1最下边大于2的最上边）
                rec1[3]<=rec2[1]);  //下（1最上边小于2的最下边）
                */

        //在x轴上的射影，最小的大于最大的有交集。
        //在y轴上的射影，最小的大于最大的有交集。
        /*
        return Math.min(rec1[2],rec2[2])>Math.max(rec1[0],rec2[0])||
               Math.min(rec1[3],rec2[3])>Math.max(rec1[1],rec2[1]);
               */


        //两个互相重叠的矩形，它们在x轴和y轴上投影出的区间也是互相重叠的
        boolean x=!(rec1[2]<=rec2[0]||rec1[0]>=rec2[2]);
        boolean y=!(rec1[3]<=rec2[1]||rec1[1]>=rec2[3]);
        return x&&y;


    }

    public static void main(String[] args) {
        int[] rec1={0,0,1,1};
        int[] rec2={1,0,2,1};
        System.out.println(isRectangleOverlap(rec1,rec2));
    }
}
