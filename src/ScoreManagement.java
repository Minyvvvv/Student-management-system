import java.util.ArrayList;
import java.util.List;

public class ScoreManagement {
/*用集合存数据（比如 ArrayList）
做几个核心功能：
添加学生
修改成绩
删除学生
查询成绩
排序（按成绩）

👉 输入方式：

控制台输入（Scanner）
或简单菜单系统*/
private List<Student> studentlist = new ArrayList<>();

//添加学生功能逻辑：学号检验+成绩范围检验
public boolean addStudent(Student stu){
    if (stu == null){
        System.out.println("输入非法。");
        return false;
    }
    //学号重复检验
    for (Student v : studentlist){
        if (v.getId().equals(stu.getId())){
            System.out.println("该学生已存在");
            return false;
        }
    }
    //成绩范围检验：0~100
    if (stu.getScore() < 0 || stu.getScore() > 100){
        System.out.println("成绩输入非法。");
        return false;
    }

    //成功添加
    studentlist.add(stu);
    return true;
}
//修改成绩：读取学生信息集合对指定学号的成绩
public boolean modifyScore(String id, double newScore) {
    if (newScore < 0 || newScore > 100) {
        System.out.println("成绩范围错误");
        return false;
    }
    for (Student s : studentlist) {
        if (s.getId().equals(id)) {
            s.setScore(newScore);
            return true;
        }
    }
    System.out.println("学号 " + id + " 不存在");
    return false;
}

//删除学生:通过学号的匹配来删除对应学生,先检验学号，
public boolean removalStudent(String id){
    for (int i = 0 ; i < studentlist.size() ; i++) {
        if (studentlist.get(i).getId().equals(id)){
            studentlist.remove(i);
            return true;
        }
    }
    System.out.println("学好不存在。");
    return false;
}

//查询成绩：传入学号来进行成绩的查询
public boolean checkResults(String id){
    for (Student s : studentlist) {
        if (s.getId().equals(id)){
            System.out.println(id + "同学的成绩为" + s.getScore() + ".");
            return true;
        }
    }
    System.out.println("学号不存在，请重新输入。");
    return false;
}

//成绩排序：初阶冒泡
public List<Student> rankStudents(){
    //创建副本
    List<Student> copy = new ArrayList<>(studentlist);

    //冒泡排序,降序，返回学生列表
    for (int i = 0; i < copy.size(); i++) {
        for (int j = 0; j < copy.size() - 1 - i; j++) {
            Student s1 = copy.get(j);
            Student s2 = copy.get(j + 1);

            if (s1.getScore() < s2.getScore()) {
                copy.set(j , s2);
                copy.set(j + 1 , s1);
            }
        }

    }
    return copy;
}

/*阿弥诺斯阿米诺斯阿米诺斯阿米诺斯阿米诺斯阿米诺斯阿米诺斯阿米诺斯阿米诺斯*/


}
/*改进方向：
1.有重复逻辑（通过ID查找学生），可以单独写一个方法来简化代码
2.排序算法仍可改进
*/