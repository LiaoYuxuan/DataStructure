package recursion;

import java.io.IOException;
import java.util.Arrays;

import static recursion.ChangeTest.getString;

public class lianxi {

    static int size;//字母长度
    static int count;
    static char[] ch = new char[5];

    public static void main(String[] args) throws IOException {
        ch[0]='1';  ch[1]='2';  ch[2]='3';  ch[3]='4'; ch[4]='5';size=5; count=0;
        Permutation(size);
    }

    /**
     * 假设有单词有n个字母。（并且假设字母均不相同）
     *
     *         1、全排列最左边的n-1个字母
     *
     *         2.打印第一步中的所有全排列
     *
     *         3、轮换所有的n个字母
     *
     *         4、重复以上步骤n次
     * @param length
     */
    public static void Permutation(int length){//参数代表字母长度
        if(length == 1){
            return;
        }else {
            for(int i = 0; i < length;i++){
                Rotate(length);
                if(length==2){
                    count++;
                    System.out.println(count+" "+Arrays.toString(ch));
                }
                Permutation(length-1);
            }
        }
    }

    public static void Rotate(int length) {
        char temp = ch[size-length];
        for(int i = size-length+1;i < size;i++){
            ch[i-1] = ch[i];
        }
        ch[size-1] = temp;
    }
}
