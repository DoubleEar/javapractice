//数组中的逆序对
public class AntiOrder {
    public static int inverseNum = 0;
    public int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        mergeSort(A, 0, A.length - 1);

        return inverseNum;
    }

    //递归对元素进行分组。
    public static void mergeSort(int[] arr, int left, int right) {
        if (left<right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    //合并两个已排好序的数组s[left...mid]和s[mid+1...right]
    //返回合并过程中累加逆序对
    public static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];    // 辅助存储空间 O(n)
        int index = 0;
        int i = left;
        int j = mid + 1;
        // 新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                // 当前一个数组元素大于后一个数组元素时，累加逆序对
                // s[i] > s[j] --> s[i]...s[mid] > s[j]
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        //返回合并过程中累加逆序对
        return inverseNum;
    }

    public static void main(String[] args) {
        AntiOrder a=new AntiOrder();
        int[] A={3,8,7,9,10,1};
        System.out.println(a.count(A,6));
    }
}
