package studyjava;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12 ,15 , 48, 7};
        System.out.println(Arrays.toString(quickSort(arr,0,3)));
    }

    public static int[] quickSort(int[] arr,int start,int end){
        int si = partition(arr,start,end);
        if(si > start){
            quickSort(arr,start,si-1);
        }
        if(si<end){
            quickSort(arr,si+1,end);
        }
        return arr;
    }

    //分区操作函数
    public static int partition(int[] arr,int start,int end){
       //基准值
        int pivot = (int)(start + Math.random()*(end-start+1));
        //将基准移到数组最后
        Utils.swap(arr,pivot,end);
        //比基准数大的角标，用于换位置
        int smallindex = start -1;
        for(int i = start; i<= end; i++){
            //大于则不处理（使用时修改此处的不等号即可，不用改别的）
            if(arr[i] <= arr[end]){
                smallindex++;
                if(i>smallindex){
                    Utils.swap(arr,i,smallindex);
                }
            }
        }
        return smallindex;
    }
}
