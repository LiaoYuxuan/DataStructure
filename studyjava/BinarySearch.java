package studyjava;

public class BinarySearch {
    public static void main(String[] args) {
        Integer[] arry = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arry[i] = i +1;
        }
        System.out.println(binarySearch(arry, 3));
        System.out.println(binarySearch(arry,0,arry.length-1,2));
    }

    /**
     * 非递归二分查找算法 参数：整形数组，需要比较的数
     */
    public static int binarySearch(Integer[] intArray, int keyValue) {
        //第一个位置
        int low = 0;
        //最高位置
        int high = intArray.length - 1;
        //当两个指针未重复时
        while (low <= high) {
            //中间位置计算，low+最高位置减去最低位置，右移一位，相当于除以2
            int middle = low + ((high - low) >> 1);
            //数字比较
            if (keyValue == intArray[middle]) {
                return middle;
            } else if (keyValue < intArray[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归实现
     *
     * @param intArray
     * @param keyValue
     * @return
     */

    public static int binarySearch(Integer[] arr, int low, int high, int keyvalue) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (keyvalue == arr[mid]) {
                return mid;
            } else if (keyvalue < arr[mid]) {
                return binarySearch(arr, low, mid - 1, keyvalue);
            } else {
                return binarySearch(arr, mid + 1, high, keyvalue);
            }
        }
        return -1;
    }
}