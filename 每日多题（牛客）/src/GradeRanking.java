import java.util.*;

//成绩排序
//输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列
// 相同成绩都按先录入排列在前的规则处理。
class Student
{
    public String name;
    public int score;
    public Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
}

public class GradeRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numPeople = scanner.nextInt();
            int option = scanner.nextInt();

            List<Student> sList = new ArrayList();

            for (int i = 0; i < numPeople; i++) {
                sList.add(new Student(scanner.next(), scanner.nextInt()));
            }

            if (option == 0) {//降序
                Collections.sort(sList, new Comparator<Student>() {
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            } else if (option == 1)//升序{
                Collections.sort(sList, new Comparator<Student>() {
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });


            for (int i = 0; i < sList.size(); i++) {
                System.out.println(sList.get(i).name + " " + sList.get(i).score);
            }
        }
    }
}
