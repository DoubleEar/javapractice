//比较两个版本号 version1 和 version2。
//输入：version1 = "1.01", version2 = "1.001"    输出：0
//解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”
public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        //用.将字符串分割为字符串数组
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");

        //纪录字符串数组的长度
        int m=v1.length;
        int n=v2.length;

        for(int i=0;i<Math.max(m,n);i++){
            //为了防止数组越界，我们选择长度大的数组。
            //如果i在长度内就将i下标所在的字符串转化为整型。这样001就能转换为1。
            //如果i超过m或n的长度，就将它当作零处理。
            int num1=i<m?Integer.parseInt(v1[i]):0;
            int num2=i<n?Integer.parseInt(v2[i]):0;

            //根据比较规则返回即可
            if(num1!=num2)
                return num1>num2?1:-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1="1.1.1";
        String s2="1.001.1";
        System.out.println(compareVersion(s1,s2));
    }
}
