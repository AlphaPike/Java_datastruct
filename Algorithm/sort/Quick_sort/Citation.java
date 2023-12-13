package Algorithm.sort.Quick_sort;

/**
 * 题目：
 *  波兰旗问题：将小于等于某个数放在数组的左边，大于等于某个数的放在数组的右边
 *  升级：将小于某个数放在数组的左边，等于某个数的放在数组的中间，大于某个数的放在数组的右边
 */
public class Citation {
    public static void q1(int[] arr, int num) {
        int left = -1;// 左边界
        for(int i = 0;i < arr.length;i ++) {
            if(arr[i] <= num) swap(arr, i, ++left); // 遍历每个数字一有符合条件的就丢到数组的左边
        }
    }

    public static void q2(int[] arr, int num) { // 对数组的每个数组检查符合条件一的丢左边符合条件二的丢右边，剩下的就是条件三的
        int left = -1;
        int right = arr.length; // 右边界
        int i = 0;
        while(i < right) {
            if(arr[i] < num) swap(arr, i++, ++left);
            if(arr[i] > num) swap(arr, i, --right); // 此处i不变，因为换过来的值还没有检查过
            if(arr[i] == num) i ++;
        }

    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
