package recursion;

public class NumberTest {
    public static void main(String[] args) {
        System.out.println(getSum(5));
        System.out.println(getX(5));
        System.out.println(getX(5,1));
    }

    //三角数字
    public static int getSum(int n){
        int totle = 0;
        if (n == 1){
            return 1;
        }
        return totle = n + getSum(n-1);
    }

    //递归阶乘
    public static int getX(int n){
        int totle = 1;
        if(n == 1){
            return 1;
        }
        return totle = n*getX(n-1);
    }

    //尾递归阶乘
    //尾递归特点：一个递归函数的返回值不属于表达式的一部分
    public static int getX(int n,int a){
       if(n == 1){
           return a;
       }else {
           int totle = getX(n - 1, n * a);
           return totle;
       }
    }
}
