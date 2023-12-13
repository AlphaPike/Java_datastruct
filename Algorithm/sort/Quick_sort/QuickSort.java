package Algorithm.sort.Quick_sort;

public class QuickSort {


    /*
        思路：
            利用波兰旗思路，保证每次调用时左边的数永远小于右边的数
            每次确定一批数的绝对位置，从而让整个数组有序
     */
    public static void quickSort(int[] arr, int L, int R) {
        if(L > R) return;
        swap(arr, R, (int)(Math.random() * (R - L + 1) + L)); // 随机抽取，让算法更高效
        int[] p = partition(arr, L, R); // 返回排好序的左
        quickSort(arr, L,p[0] - 1);
        quickSort(arr, p[1] + 1, R);

    }

    private static int[] partition(int[] arr, int L, int R) {
        int numPoint = R--; // 最后一个数作为要确定位置的
        int i = L;
        while(i <= R) {
            if(arr[i] < arr[numPoint]) swap(arr, i ++, L ++);
            else if(arr[i] > arr[numPoint]) swap(arr, i, R --);
            else i ++;
        }
        swap(arr, numPoint, ++ R);
        return new int[]{L, R};
    }

    private static void swap(int[] arr, int point1, int point2) { // 此处不能用与交换
        int temp = arr[point1];
        arr[point1] = arr[point2];
        arr[point2] = temp;
    }




}
