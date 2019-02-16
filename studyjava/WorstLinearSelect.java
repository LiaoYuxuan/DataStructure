package studyjava;

import java.util.Arrays;
import java.util.Random;

public class WorstLinearSelect {
    public static void main(String[] args) {
        int n = 34, k = 7;/* 34个元素中找出第7小的元素 */
        int[] a = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Select(a, 0, n - 1, k));/* 进行线性查找 */
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));/* 排序后输出，进行验证 */
    }

    //查找第i大的元素
    public static int Select(int[] arr ,int p ,int q,int k){
        if (q - p < 5) {
            InsertSort(arr, p, q);
            return arr[p + k - 1];
        }
        int teams = (q - p + 5) / 5;// 组数
        for (int i = 0; i < teams; i++) {
            /* 第一步：将输入数组的n个元素划分为n/5组，每组5个元素，且至多只有一个组由剩下的n mod5个元素组成 */
            int left = p + i * 5;
            int right = (p + i * 5 + 4) > q ? q : p + i * 5 + 4;//若超出边界则取边界
            int mid = (left + right) / 2;
            /* 第二步：寻找(n+4)/5个组中每一组的中位数。首先对每组中的元素（至多为5个）进行插入排序，然后从排序过的序列中选出中位数 */
            InsertSort(arr, left, right);
            Utils.swap(arr, p + i, mid);// 将中位数置前
        }
        /* 第三步：对第二步中找出的(n+4)/5个中位数，递归调用select以找出其中位数x */
        int pivot = Select(arr, p, p + teams - 1, (teams + 1) / 2);
        /* 第四步：利用修改过的partition过程，按中位数的中位数x对输入数组进行划分 */
        int pos = Partition(arr, p, q, pivot);
        /* 第五步：判断pos位置是否为要找的数，若不是则在低区或者高区递归select */
        int leftNum = pos - p;
        if (k == leftNum + 1)
            return arr[pos];
        else if (k <= leftNum)
            return Select(arr, p, pos - 1, k);
        else
            return Select(arr, pos + 1, q, k - leftNum - 1);
    }

    private static int Partition(int[] arr, int p, int q,int pivot) {
        int index = p;
        for (int i = p; i <= q; i++) {
            if (arr[i] == pivot) {
                index = i;
                break;
            }
        }/* 找到枢纽的位置 */
        Utils.swap(arr, index, q);
        int i = p - 1;
        for (int j = p; j < q; j++) {
            if (arr[j] <= pivot) {
                Utils.swap(arr, j, ++i);
            }
        }
        Utils.swap(arr, q, ++i);
        return i;
    }


    public static void InsertSort(int[] arr,int p,int q) {
        for (int i = p + 1; i <= q; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= p && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }
    }


}
