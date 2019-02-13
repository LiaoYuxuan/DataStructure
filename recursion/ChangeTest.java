package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChangeTest {
    static int size;//字母长度
    static int count;//排列组合的种数
    static char[] ch = new char[100];

//    变位字问题的实质：嵌套式的轮换
//    for(int i = 0; i < 4;i++){
//        Rotate(4);
//        for(int j = 0; j < 3;j++){
//            Rotate(3);
//            for(int k = 0; k < 2;k++){
//                Rotate(2);
//                System.out.println(Arrays.toString(ch));
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        System.out.println("请输入字母：");
        String s = getString();
        size = s.length();
        count = 0;
        for(int i = 0; i<size; i++){
            ch[i] = s.charAt(i);
        }
        doChange(size);
    }

    public static void doChange(int length){//参数代表字母长度
        //递归出口
        if(length == 1){
            return;
        }
        //递归入口
        //设处理的字符串长度为length，则字符串的第一位有length种情况
        for(int i =  0; i < length; i++){
            //向前移动length-1位，循环n次
            doChange(length-1);
            if(length==2){
                //打印本次
                display();
            }
            //移动的函数
            move(length);
        }
    }

    private static void display() {
        System.out.print(++count + "");
        for (int i = 0; i<size;i++){
            System.out.print(ch[i]);
        }
        System.out.print("  ");
        System.out.flush();
        if(count %6 == 0){
            System.out.println();
        }
    }

    //将最后一位字母向前移动length-1位
    private static void move(int length) {
        int j;
        int position = size - length;
        char temp = ch[position];
        for(j = position + 1; j<size;j++){
            ch[j-1] = ch[j];
        }
        ch[j-1] = temp;
    }

    public static String getString() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String string =br.readLine();
        return string;
    }


}
