//数组中只出现一位的数字
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。
// 请写程序找出这两个只出现一次的数字。
public class ValueAppearsOnce {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int n=array.length;
        if(n==2){
            num1[0]=array[0];
            num2[1]=array[1];
            return;
        }

        //第一步：将数组中的每一个数字都异或 -> 两个相同的数异或的结果是0。
        //最终结果是两个只出现了一次的数（a，b）的异或。
        //1 1 2 2 3 4 5 5 -> 3^4=7(0111)
        int bitResult=0;
        for(int i=0;i<n;i++){
            bitResult^=array[i];
        }

        int index=findFirstOne(bitResult);
        for(int i=0;i<n;i++){   //两个只出现一次的数位于不同的数组。
            if(isBit(array[i],index))   //0与任何数异或的结果都是他本身。
                num1[0]^=array[i];  //成对出现的数肯定在一个数组，并且异或的结果为0。
            else
                num2[0]^=array[i];
        }
    }

    //第二步：找到一位为1的比特位。第一步的结果0111，表示有a b有三位是不同的。
    private static int findFirstOne(int n){
        int index=0;
        while ((n&1)==0&&index<32){ //随便找到一个第一步结果中为1的比特位，用来将这两个数分开。
            n>>=1;
            index++;
        }
        return index;
    }

    //第三步：判断数组中的每一个数的index位置是不是1，进而将两个数分开。
    private static boolean isBit(int target,int n){
        return ((target>>n)&1)==1;
    }

    public static void main(String[] args) {
        int[] array={1,1,2,2,3,4,5,5};
        int[] num1=new int[1];
        int[] num2=new int[1];
        FindNumsAppearOnce(array,num1,num2);
    }
}
