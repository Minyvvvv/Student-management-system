import model.Student;
import model.User;
import model.Database;
import java.util.Scanner;

import static model.User.Password_verification;
import static model.User.exist;
import static util.FileUtil.*;


public class console {
    //学生管理系统控制台（v0.5）
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //调用FileUtil里的方法进行用户信息加载，比对以及写入
        initFile();
        loadUsers(Database.Userdata);
        while (true) {
            System.out.println("请按照以下提示进行操作，输入相应数字进行操作：");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            //测试结果显示此处循环有错误，登陆成功不能直接进入系统(已解决)，次数用完之后没有提示次数耗尽重新进入系统
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    //调用登录操作
                    //先进行用户登陆验证，调用signIn方法
                    int sighIN_res = -1;
                    int Maximum_number_of_attempts = 0;//初始化尝试次数
                    //对登录次数进行限制，最多为3次
                    while (Maximum_number_of_attempts < 3) {
                        User user = new User();//空参构造
                        System.out.println("请输入账号：");
                        String temp_user = sc.next();
                        System.out.println("请输入密码：");
                        String temp_password = sc.next();

                        sighIN_res = user.signIn(temp_user, temp_password);//验证步骤

                        /*if (sighIN_res == 0){
                            break;
                        }*/
                        if (sighIN_res != 0) {
                            System.out.println("登录失败，您已尝试 " + (Maximum_number_of_attempts+1) + " 次，最多允许 3 次。");
                            if (Maximum_number_of_attempts == 2) {
                                System.out.println("达到最大尝试次数，返回主菜单。");
                            }
                        }
                        Maximum_number_of_attempts++;
                        if (sighIN_res == 0){

                            showMainMenu(sc);
                            break;
                        }
                    }
                    //经过循环后判断是否能进入登陆成功的操作界面
                    break;
                case 2://注册操作
                    System.out.println("正在进行注册操作......");
                    System.out.println("请输入账号：");
                    String account = sc.next();
                    System.out.println("请输入密码：");
                    String password = sc.next();
                    //账号密码验证
                    if(exist(account)){
                        break;
                    }
                    if (!Password_verification(password)) {
                        System.out.println("密码必须包含数字、字母和特殊字符！");
                        break;
                    }
                    User tempuser = new User(account , password);
                    Database.Userdata.add(tempuser);
                    saveUser(tempuser);
                    System.out.println("注册成功！");
                    continue;
                case 3://退出系统
                    System.out.println("正在执行退出操作......");
                    sc.close();
                    return;
                default://强制退出
                    System.out.println("非法操作，正在强制退出.....");
                    sc.close();
                    return;
            }
        }
    }
    private static void showMainMenu(Scanner sc) {
        //将main方法里new的scanner作为参数传到方法中
        /*为用户提供功能选项的面板，包括添加学生，删除学生，修改成绩，查询学生成绩*/
        while (true) {


            //系统提示信息
            System.out.println("欢迎来到学生管理系统，请根据以下选项进行操作：");
            System.out.println("1.添加学生\n2.删除学生\n3.修改成绩\n4.查询学生成绩\n5.退出系统");

            int answer = sc.nextInt();

            //判断部分
            switch (answer) {
                case 1:
                    System.out.println("请输入您要添加的学生信息（姓名，学号，成绩）");
                    String name = sc.next();
                    String id = sc.next();
                    double score = sc.nextDouble();
                    //调用Student类
                    Student stu = new Student(id, name, score);
                    //调用学生成绩管理系统中的添加学生方法
                    ScoreManagement.addStudent(stu);

                    break;
                case 2:
                    //调用删除学生方法
                    System.out.println("请输入要删除学生的学号（ID）:");
                    String idDelete = sc.next();
                    ScoreManagement.removalStudent(idDelete);
 
                    break;
                case 3:
                    //通过学号来修改学生成绩
                    System.out.println("请输入要修改成绩的学生学号：");
                    String idMdify = sc.next();
                    System.out.println("请输入新的成绩：");
                    double newScore = sc.nextDouble();
                    ScoreManagement.modifyScore(idMdify, newScore);

                    break;
                case 4:
                    //通过学号来查看学生信息
                    System.out.println("请输入要查询的学生学号：");
                    String idCheck = sc.next();
                    ScoreManagement.checkResults(idCheck);
                    break;
                case 5:
                    //退出系统
                    System.out.println("退出系统。");
                    sc.close();//释放内存，防止资源泄露
                    return;  // 退出程序
                default:
                    System.out.println("无效选项，请重新选择。");
                    continue;
            }
        }
    }
    }




