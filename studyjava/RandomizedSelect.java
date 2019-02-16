package studyjava;

import java.util.Arrays;
import java.util.Random;

public class RandomizedSelect {
    private static Random random = new Random();

    public static void main(String[] args) {
       int[] arr = new int[20];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        //测试使用
        System.out.println(Arrays.toString(arr));
        System.out.println(RandomSelect(arr,0,arr.length-1,10));
        System.out.println(Arrays.toString(arr));
    }

    //找到数组中第i大的元素
    public static int RandomSelect(int[] arr , int p ,int q ,int i){
        //如果数组片段中只有一个元素
        if(p == q){
            return arr[p];
        }
        //划分数组，（认为左侧小，右侧大）
        int r = RandomPartition( arr,p,q);
        //k是划分元素的序号
        int k = r - p +1;
        //第i大元素在数组中的位置为i-1
        if(i == k){
            return arr[r];
        }else if(i < k){
            return RandomSelect(arr, p, r-1, i);
        }else{
            return RandomSelect(arr, r+1, q, i-k);
        }
    }

    private static int RandomPartition(int[] arr, int l, int r) {
        //产生随机数
        int pivot = (int)(random.nextInt(r-l)+l);
        int temp = arr[pivot];
        Utils.swap(arr,pivot,r);
        int index = l -1;
        for(int i = l; i<= r; i++){
            //大于则不处理
            if(arr[i] <= arr[r]){
                index++;
                if(i>index){
                    Utils.swap(arr,i,index);
                }
            }
        }
        return index;
    }
}
