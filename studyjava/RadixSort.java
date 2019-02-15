package studyjava;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {12 ,15 , 48, 7 ,3 ,224 ,1980};
        System.out.println(Arrays.toString(radixSort(arr)));

    }

    public static int[] radixSort(int[] arr){
        if(arr == null || arr.length<2){
            return arr;
        }
        int max = arr[0];
        //找到最大值
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        //最大的数字有几位
        int maxDigit = 0;
        while(max!=0){
            max/=10;
            maxDigit++;
        }
        //每一位的倍数差
        int mod = 10;
        //除法的基准值
        int div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        //每一位的值在0-9之间
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++,mod*=10,div*=10) {
            for (int j = 0; j < arr.length; j++) {
                //第一次循环时取出个位数
                int num = (arr[j] % mod)/div;
                bucketList.get(num).add(arr[j]);
            }
            int index = 0;
            //回填
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    arr[index++] = bucketList.get(j).get(k);
                }
                //回填后清空
                bucketList.get(j).clear();
            }
        }
        return arr;
    }
}
