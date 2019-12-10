import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            User user = login();
            System.out.println("欢迎" + user.name + "登录");
            user.menu();
            System.out.println("请选择：");
            int select=scanner.nextInt();
            user.operation(select);
        }
    }
    private static User login(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择：1.老师 2.学生");
        int select=scanner.nextInt();
        User u;
        if(select==1){
            u=new TeacherUser();
            u.name="耳耳";
        }else{
            u=new StudentUser();
            u.name="耳耳";
        }
        return u;
    }
}
