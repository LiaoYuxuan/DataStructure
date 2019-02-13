package studyjava;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {12 ,15 , 48, 7};
		InsertSort(arr);
	}
	/**
	 * 插入排序
	 * @param arr
	 * @return
	 */
	public static void InsertSort(int[] arr) {
		if(arr == null || arr.length <=1) {
			return ;
		}
		//设置当前拿出来的元素
		int current ;
		for(int i = 0 ; i < arr.length -1 ; i++) {
			current = arr[i+1];
			//设置上一个元素角标
			int preindex = i;
			//不知道循环次数时使用while
			while(preindex >= 0 && current < arr[preindex]) {
				//将上一元素后移
				arr[preindex+1] = arr[preindex];
				preindex--;
			}
			//将拿出的元素插在后面
			arr[preindex+1] = current;
		}
		System.out.println(Arrays.toString(arr));
	}

}
