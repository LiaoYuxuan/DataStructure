package studentmanager;

public class Student {
    private int number;
    private String name;
    private int age;
    private int python;
    private int java;
    private int linux;
    private int sql;
    private int sum;
    private double avg;

    Student(int number ,String name,int age){
        this.number=number;
        this.name=name;
        this.age=age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getLinux() {
        return linux;
    }

    public void setLinux(int linux) {
        this.linux = linux;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getSum() {
        return sum;
    }

    public void setSum() {
        this.sum = this.python+this.java+this.linux+this.sql;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg() {
        this.avg = (double)this.sum/4;
    }

    public String toString(){
        String msg="\t\t"+this.number+"\t\t"+this.name+"\t\t"+this.age+"\t\t"+this.python
                +"\t\t"+this.java+"\t\t"+this.linux+"\t\t"+this.sql+"\t"+this.sum+"\t"+this.avg;
        return msg;
    }

}
