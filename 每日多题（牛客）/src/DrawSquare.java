import java.util.Scanner;
//和奥巴马一起画正方形
public class DrawSquare {
    /*
    aaaaaaaaaa
    a        a
    a        a
    a        a
    aaaaaaaaaa
     */
    private static void drawSquare(int n,char c){
        int row=n;
        int col;
        if(row%2!=0){
             col=row/2+1;
        }else{
            col=row/2;
        }
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                //第一行，最后一行，第一列，最后一列输出字符
                if(j==0||j==row-1||i==0||i==col-1){
                    System.out.print(c);
                }else{
                    //其余的输出空格
                    System.out.print(" ");
                }
            }
            //每打印完一行就换行
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char c=sc.next().charAt(0);
        drawSquare(n,c);
    }
}
