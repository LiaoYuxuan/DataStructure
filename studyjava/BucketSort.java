package studyjava;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(5);
        arrayList.add(77);
        arrayList.add(11);
        arrayList.add(3);
        arrayList.add(76);
        arrayList.add(76);
        System.err.println(bucketSort(arrayList,3));

    }

    //使用数组链表是为了大小不限
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> arr, int bucketSize) {
        if (arr == null || arr.size()<2) {
            return arr;
        }
        int min = arr.get(0), max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        //加1是为了避免为零
        int bucketCount = (max - min) / bucketSize + 1;
        //外层
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketCount);
        //回填的结果
        ArrayList<Integer> resultArr = new ArrayList<Integer>();
        //初始化桶
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //将原来的数据填充到应该填充的位置
        for (int i = 0; i < arr.size(); i++) {
            bucketArr.get((arr.get(i) - min) / bucketSize).add(arr.get(i));
        }
        //递归地将桶里的数据进行排序，并放回原数组中
        for (int i = 0; i < bucketCount; i++) {
            //有重复数据出现时候的一个判断
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                //说明bucketsize太大
                if (bucketCount == 1) {
                    //避免递归时数据少，size大
                    bucketSize--;
                }
                //bucketsize不能为零
                //递归式的进行桶排序
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                //将排序号的序列放在返回结果中
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

}

