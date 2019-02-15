package studyjava;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {12 ,15 , 48, 7};
        System.out.println(Arrays.toString(countingSort(arr)));
    }

    public static int[] countingSort(int[] arr){
        int min = arr[0],max = arr[0];
        //找到最大最小值
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }

        int[] bucket = new int[max - min +1];
        Arrays.fill(bucket,0);
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]-min]++;
        }
        int index = 0,i = 0;
        while(index<arr.length){
            if(bucket[i]!=0){
                arr[index] = i + min;
                bucket[i]--;
                index++;
            }else{
                i++;
            }
        }
        return arr;
    }
}
