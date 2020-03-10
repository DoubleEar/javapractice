import java.util.HashMap;

/*每辆车 i 以恒定的速度 speed[i] （英里/小时）
从初始位置 position[i] （英里） 沿车道驶向目的地。
一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。
注意，一辆车也可以是一个车队。
*/
public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
            if(position.length<=1)
                return position.length;
        HashMap<Integer,Integer> hashMap=new HashMap<>(position.length);
        for(int i=0;i<position.length;i++){
            hashMap.put(position[i],speed[i]);
        }

        Merge(position);
        double minTime=(double)(target-position[0])/hashMap.get(position[0]);
        int max=1;
        for(int s:position){
            int len=target-s;
            double time=(double)len/hashMap.get(s);
            //如果当前的时间大于最短时间，那么一定追不上。
            if(time>minTime){
                minTime=time;
                //新加一个车队
                max++;
            }
        }
        return max;
    }

    public static void Merge(int[] arr){
        int[] temp=new int[arr.length];
        MergeSort(arr,0,arr.length-1,temp);
    }

    public static void MergeSort(int[] arr,int left,int right,int[] temp){
        if(left>=right)
            return;
        int mid=(left+right)/2;
        MergeSort(arr,left,mid,temp);
        MergeSort(arr,mid+1,right,temp);
        MergeInteral(arr,left,mid,right,temp);
    }

    public static void MergeInteral(int[] arr,int left,int mid,int right,int[] temp){
        int begin1=left,end1=mid;
        int begin2=mid+1,end2=right;
        int index=left;

        while (begin1<=end1&&begin2<=end2) {
            if (arr[begin1] >= arr[begin2]) {
                temp[index++] = arr[begin1++];
            } else {
                temp[index++] = arr[begin2++];
            }
        }

            while (begin1<=end1)
                temp[index++]=arr[begin1++];
            while (begin2<=end2)
                temp[index++]=arr[begin2++];

            for(int i=left;i<=right;i++){
                arr[i]=temp[i];
            }
    }

    public static void main(String[] args) {
        int[] position={10,8,0,5,3};
        int[] speed={2,4,1,1,3};
        System.out.println(carFleet(12,position,speed));
    }
}
