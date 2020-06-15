import java.util.*;
//员工的重要性
class Employee {
    public int id;
    public int importance;  //重要度
    public List<Integer> subordinates;  //所有下属
}

public class GetImportance {
    //现在输入一个公司的所有员工信息，以及单个员工id
    // 返回这个员工和他所有下属的重要度之和。

    /*
    public int getImportance(List<Employee> employees, int id) {
        int res=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(id);
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee employee:employees){   //方便查找
            map.put(employee.id,employee);
        }

        while (!queue.isEmpty()){
            Employee cur=map.get(queue.poll());
            res+=cur.importance;
            for(int curId:cur.subordinates){    //将所有下属加入队列
                queue.offer(curId);
            }
        }
        return res;
    }
    */


    private int DFS(Map<Integer,Employee> map,int id){
            Employee curEmp=map.get(id);
            int res=curEmp.importance;

            for(int curId:curEmp.subordinates){
                res+=DFS(map,curId);
            }

            return res;
        }

    public int getImportance(List<Employee> employees, int id) {
        if(employees.isEmpty())
            return 0;
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }

        return DFS(map,id);
    }
}
