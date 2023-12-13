package Algorithm.sort.Merge_Sorts;

/**
 * 题目：P4 1:24 P4 1:28
 *  1.计算小和：对一个数组中的每个数左边的所有数累加起来
 *  2.计算逆序对个数，逆序对：左边的数比右边的数大
 */
public class Trick {
    int process(int[] arr, int L, int R) {
        if(L == R) return 0;
        int mid = L + (R - L) >> 1;
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    int merge(int[] arr, int L, int mid, int R) {
        int i = L, j = mid + 1, k = 0, sum = 0;
        int size = R - L + 1;
        int[] help = new int[size];
        while(i <= mid && j <= R) {
            sum += arr[i] < arr[j] ? (R - i + 1) * arr[i] : 0;
            help[k ++] = arr[i] < arr[j] ? arr[i ++] : arr[j ++];
        }
        while(i <= mid) help[k ++] = arr[i ++];
        while(j <= R) help[k ++] = arr[j ++];
        for (int t = 0;t < size;t ++) {
            arr[L + t] = help[t ++];
        }
        return sum;
    }

    public static void main(String[] args) {
        new Trick().process(new int[]{4,2,1,455,34,12}, 0, 5);
    }
}


/*
    逆序数问题：
        分治算法：将数组分成三个部分分别求解
        题目思路：左数组的逆序数 + 右数组的逆序数 + 两者关联数组的逆序数
        递归思想：每次递归返回各边数组的逆序数，假设算法已经实现，返回结果值为左边逆序数个数 + 右边逆序数个数，求中间逆序数个数，并将数组排序
 */

