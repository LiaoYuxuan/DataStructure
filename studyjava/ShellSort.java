package studyjava;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {12 ,15 , 48, 7};
		ShellSort(arr);
	}

	/**
	 * 希尔排序（缩小增量排序）
	 * @param arr
	 * @return
	 */
	public static void ShellSort(int[] arr) {
		int len = arr.length;
		int current;
		//增量
		int gap = len/2;
		while(gap > 0) {
			for(int i = gap; i < len ; i++) {
				int preindex = i - gap;
				current = arr[i];
				while(preindex >= 0 && current < arr[preindex]) {
					arr[preindex+gap]=arr[preindex];
					preindex-=gap;
				}
				arr[preindex+gap]=current;
			}
			gap /= 2 ;
		}
		System.out.println(Arrays.toString(arr));
	}

}
