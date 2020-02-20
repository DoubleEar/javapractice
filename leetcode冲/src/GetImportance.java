import java.util.*;
//员工的重要性，上属与直系下属的重要度相加。
class Employee {
    //员工的id
    public int id;
    //员工的重要度
    public int importance;
    //直系下属员工的id
    public List<Integer> subordinates;
    Employee(int id,int importance,List<Integer> subordinates){
        this.id=id;
        this.importance=importance;
        this.subordinates=subordinates;
    }
}

public class GetImportance {
    static Map<Integer, Employee> map = new HashMap<>();

    public static int getImportance(List<Employee> employees, int id) {
        //将所有的员工插入map。key为各自的id，value为employee1~3
        for (Employee t : employees)
            map.put(t.id, t);
        //广度优先搜索 把指定员工的id传入
        return bfs(id);
    }

    private static int bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        //加入员工的id
        q.offer(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            //获取当前id的员工
            Employee current = map.get(v);
            //将员工的重要度加起来
            sum += current.importance;
            //遍历当前员工直系下属的id
            for (int sub : current.subordinates)
                //将下属的id插入到队列中
                q.offer(sub);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();

        List<Integer> list1=new ArrayList<>();
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        List<Integer> list3=new ArrayList<>();

        Employee employee1=new Employee(1,5,list1);
        Employee employee2=new Employee(2,3,list2);
        Employee employee3=new Employee(3,3,list3);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println(getImportance(employees,1));
    }
}

