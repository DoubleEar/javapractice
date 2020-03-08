import java.sql.*;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //可能抛异常，受查异常。
        Class.forName( "com.mysql.jdbc.Driver" );
        //2.获取链接
        //先指定MySql服务器的位置
        // "jdbc:mysql://127.0.0.1:3306/有效的数据库的名字?useSSL=false&characterEncoding=utf8";
        String url="jdbc:mysql://127.0.0.1:3306/java_14_0308?useSSL=false&characterEncoding=utf8";
        //连接数据库的用户名
        String user="root";
        //连接数据库的密码
        String password="";
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);
        //3.循环
        // 从 Scanner 中不停的读 SQL，并执行
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("mysql> ");
            String sql = scanner.nextLine();
            if (sql.equals("quit")) {
                break;
            }
            // a) 创建一个 Statement 语句
            Statement statement = connection.createStatement();

            // b) 执行
            if (sql.startsWith("select")||sql.startsWith("show")||sql.startsWith("desc")) {
                ResultSet rs = statement.executeQuery(sql);
                //拿到结果集的元信息
                ResultSetMetaData metaData=rs.getMetaData();
                //获取列数
                int columnCount = metaData.getColumnCount();
                //打印列名
                for(int i=0;i<columnCount;i++){
                    String columnName=metaData.getColumnName(i+1);
                    System.out.print(columnName+" ");
                }
                System.out.println();
                while (rs.next()) {
                    //下标从1开始，可以是字段名，可以是下标
                    for (int i = 1; i <= columnCount; i++) {
                        String result = rs.getString(i);
                        System.out.print(result + " ");
                    }
                    System.out.println();
                }
                rs.close();
            } else {
                int n = statement.executeUpdate(sql);
                System.out.printf("%d 行收到影响%n", n);
            }

            statement.close();
        }
        //4.关闭链接
        connection.close();
    }
}
