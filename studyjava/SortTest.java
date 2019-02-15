package studyjava;

import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50000);
        }
        System.out.println("初始化数组："+arr[0]+"..."+arr[49999]);

        //50000以内的数据用简单排序可行，超过则最好用高级排序

//        Long start = System.currentTimeMillis();
////        int[] res = RadixSort.radixSort(arr);
////        Long end = System.currentTimeMillis();
////        System.out.println("基数排序的时间："+(end - start)/1000 + "秒");
////        for(int i = 0; i<20;i++){
////            System.out.println(res[i]);
////        }

        Long start = System.currentTimeMillis();
        BubbleSort.BubbleSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("基数排序的时间："+(end - start)/1000 + "秒");
        for(int i = 0; i<20;i++){
            System.out.println(arr[i]);
        }

    }

}
