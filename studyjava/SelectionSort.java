package studyjava;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {12 ,15 , 48, 7};
		SelectionSort(arr);
	}
	/**
	 * 选择排序
	 * @param arr
	 * @return
	 */
	public static void SelectionSort(int[] arr) {
		if(arr == null || arr.length <=1) {
			return ;
		}
		//外层循环：选择排序需要的轮数，等于数组的长度
		for (int i = 0 ; i < arr.length ; i++) {
			int minidex = i ;
			//内层循环：数据比较
			for (int j = i ; j < arr.length ; j++) {
				if(arr[j]<arr[minidex]) {
					minidex = j;
				}
			}
			if(minidex != i) {
				Utils.swap(arr, minidex, i);
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
