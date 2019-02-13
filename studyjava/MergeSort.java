package studyjava;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
       int[] array ={3,8,1,0,2,33};
       System.out.println(Arrays.toString(mergeSort(array)));
    }
    //Divide and Conquer分治法
    public static int[] mergeSort(int[] arry){
        if(arry.length<2){
            return arry;
        }
        int mid = arry.length/2;
        int[] left = Arrays.copyOfRange(arry,0,mid);
        int[] right = Arrays.copyOfRange(arry,mid,arry.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    //合并
    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        for(int index = 0,i=0,j=0;index<result.length;index++){
            if(i>=left.length){
                result[index] = right[j++];
            }else if(j>=right.length){
                result[index] = left[i++];
            }else if(left[i]>right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return result;
    }
}
