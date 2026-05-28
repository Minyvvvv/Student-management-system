import User.User;

import java.util.Scanner;

import static User.Database.Userdata;

public class console {
    //学生管理系统控制台（v0.1）
    /*为用户提供功能选项的面板，包括添加学生，删除学生，修改成绩，查询学生成绩*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //先进行用户登陆验证，调用signIn方法

        User user = new User();


        System.out.println("请输入账号：");
        String temp_user = sc.next();
        System.out.println("请输入密码：");
        String temp_password = sc.next();

        boolean sighIN_res = user.signIn(temp_user, temp_password);


        if (sighIN_res) {
            //登陆成功显示界面
            showMainMenu();
        } else {
            //未注册或登陆失败显示界面：包含多种原因，需要逐一进行处理给出相应的操作反馈
            //初期就只做一个未注册的反馈
            System.out.println("您输入的账户未注册，是否进行注册？Yes/No");
            String res = sc.next();
            if (res.equals("Yes")) {
                System.out.println("请输入账号：");
                String username = sc.next();
                System.out.println("请输入密码：");
                String password = sc.next();
                Userdata.add(new User(username, password));
                showMainMenu();
            } else {
                System.out.println("退出系统中......");
                sc.close();
            }
        }
    }
    private static void showMainMenu() {
        Scanner sc = new Scanner(System.in);

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

            }
        }
    }
    }




