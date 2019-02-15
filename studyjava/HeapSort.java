package studyjava;

import java.util.Arrays;

public class HeapSort {
    private static int len;

    public static void main(String[] args) {
        int[] arr = {12 ,15 , 48, 7};
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    public static int[] heapSort(int[] arr){
        len = arr.length;
        //构建大顶堆
        buildMaxHeap(arr);
        //将顶部元素与无序区的最后一个元素交换
        while (len > 0){
            //0是大顶元素，len-1是最后一个元素
            Utils.swap(arr,0,len-1);
            //无序区长度减少
            len--;
            //继续调整
            changeHeap(arr,0);
        }
        return arr;
    }

    //构建一个大顶堆
    public static void buildMaxHeap(int[] arr){
        for (int i = (len / 2);i >= 0; i--){
            //调整大顶堆
            changeHeap(arr,i);
        }
    }

    //调整大顶堆
    private static void changeHeap(int[] arr, int i) {
        int maxindex = i;
        //若有左子树且大于父节点
        if(i*2 < len && arr[i*2] > arr[maxindex]){
            maxindex = i*2;
        }
        //若有右子树且大于父节点
        if(i*2+1 < len && arr[i*2+1] > arr[maxindex]){
            maxindex = i*2 +1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换
        if(maxindex != i){
            Utils.swap(arr,maxindex,i);
            changeHeap(arr,maxindex);
        }
    }
}
