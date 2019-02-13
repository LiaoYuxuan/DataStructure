package studentmanager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentMain {
    public static void main(String[] args) throws Exception{
        StudentManage manage=new StudentManage();
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            manage.menu();
            int no=Integer.parseInt(bf.readLine());
            switch (no){
                case 10://10:添加学生
                    System.out.println("请输入学号");
                    int num=Integer.parseInt(bf.readLine());
                    System.out.println("请输入姓名");
                    String name=bf.readLine();
                    System.out.println("请输入年龄");
                    int age=Integer.parseInt(bf.readLine());
                    Student stu=new Student(num,name,age);
                    manage.addStu(stu);
                    break;
                case 11://11:查找学生
                    System.out.println("请输入你要查找的学号");
                    int num1=Integer.parseInt(bf.readLine());
                    manage.selectStu(num1);
                    break;
                case 12://12:更新学生信息
                    System.out.println("请输入你要更新的学生的学号");
                    int num2=Integer.parseInt(bf.readLine());
                    System.out.println("请输入新的姓名");
                    String name2=bf.readLine();
                    System.out.println("请输入新的年龄");
                    int age2=Integer.parseInt(bf.readLine());
                    manage.updateStu(num2,name2,age2);
                    break;
                case 13://13:根据学号删除学生
                    System.out.println("请输入删除的学生的学号");
                    int num3=Integer.parseInt(bf.readLine());
                    manage.deleteStu(num3);
                    break;
                case 14://14:根据学生编号输入学生各门成绩
                    System.out.println("请输入学号");
                    int num4=Integer.parseInt(bf.readLine());
                    System.out.println("请输入python成绩");
                    int python=Integer.parseInt(bf.readLine());
                    System.out.println("请输入java成绩");
                    int java=Integer.parseInt(bf.readLine());
                    System.out.println("请输入Linux成绩");
                    int linux=Integer.parseInt(bf.readLine());
                    System.out.println("请输入sql成绩");
                    int sql=Integer.parseInt(bf.readLine());
                    manage.input(num4,python,java,linux,sql);
                    break;
                case 99://99:退出系统
                    System.exit(0);
                    break;
                default:
                    System.out.println("请重新输入");
            }
        }
    }

}
