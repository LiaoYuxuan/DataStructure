package studyjava;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {12 ,15 , 48, 7};
		BubbleSort(arr);
	}

	/**
	 * 冒泡排序
	 * @param arr
	 * @return
	 */

	public static void BubbleSort(int arr[]) {
		if(arr == null || arr.length <=1) {
			return ;
		}
		//外层的for循环指冒泡操作的次数，大小为arr.length-1
		for(int i = 0 ; i < arr.length-1 ; i++) {
			//内层的for循环是指每一轮冒泡操作中数据比较与交换
			for(int j = 0 ; j < arr.length-1-i ; j++) {
				if( arr[j]>arr[j+1] ) {
					Utils.swap(arr, j, j+1);
				}
			}
		}
		//System.out.println(Arrays.toString(arr));
	}

}
