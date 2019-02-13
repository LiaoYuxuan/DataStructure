package studentmanager;

import java.util.HashMap;
import java.util.Iterator;

public class StudentManage {
    private HashMap map=null;
    String msg="\t\t学号\t\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\tsum\tavg";
    StudentManage(){
        map=new HashMap();
    }
    public void menu(){
        System.out.println("-----请选择你要执行的功能-----");
        System.out.println("10:添加一个学生");
        System.out.println("11:查找一个学生");
        System.out.println("12:根据学号更新学生基本信息");
        System.out.println("13:根据学号删除学生");
        System.out.println("14:根据学生编号输入学生各门成绩");
        System.out.println("99:退出系统");
        System.out.println("----------------------------");
    }
    //显示所有学生信息
    public void showStu(){
        if(map.size()==0) {
            System.out.println("没有学生");
        }else{
            System.out.println("一共有"+map.size()+"个学生");
            System.out.println(msg);
            Iterator it=map.keySet().iterator(); //取出所有的key
            while(it.hasNext()){ //是否有下一个key
                int key=Integer.parseInt(it.next().toString()); //取出下一个key
                Student stu=(Student)map.get(key);
                System.out.println(stu);
            }
        }
    }
    //10:添加一个学生
    public void addStu(Student stu){
        int key=stu.getNumber();
        map.put(key,stu);
        System.out.println("添加学生成功");
        showStu();
    }
    //11:查找一个学生
    public void selectStu(int num){
        if(map.containsKey(num)){
            System.out.println(msg);
            Student stu=(Student)map.get(num);
            System.out.println(stu);
        }else{
            System.out.println("没有这个学号的学生");
        }
    }
    //12:根据学号更新学生基本信息
    public void updateStu(int number,String name,int age){
        if(map.containsKey(number)){
            Student stu=(Student)map.get(number);
            stu.setName(name);
            stu.setAge(age);
            System.out.println("学生信息更新成功");
            showStu();
        }else{
            System.out.println("没有这个学号的学生");
        }
    }
    //13:根据学号删除学生
    public void deleteStu(int number){
        if(map.containsKey(number)){
            map.remove(number);
            System.out.println("学生删除成功");
            showStu();
        }else{
            System.out.println("没有这个学号的学生");
        }
    }
    //14:根据学号输入学生各门成绩
    public void input(int number,int python,int java,int linux,int sql){
        if(map.containsKey(number)){
            Student stu=(Student)map.get(number);
            stu.setPython(python);
            stu.setJava(java);
            stu.setLinux(linux);
            stu.setSql(sql);
            stu.setSum();
            stu.setAvg();
            System.out.println("学生成绩录入成功");
            showStu();
        }else{
            System.out.println("没有这个学号的学生");
        }
    }
}
