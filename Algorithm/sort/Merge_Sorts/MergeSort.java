package Algorithm.sort.Merge_Sorts;

public class MergeSort {
    public static void main(String[] args) {
        int[]  k = new int[]{5,2,3,1};
        new MergeSort().sort(k);
        for(int p:k) System.out.println(p);
    }

    //一部分排序
    public void sort (int[] arr, int L, int R) {
        process(arr, 0, arr.length - 1);
    }

    //全排序
    public void sort (int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void process (int[] arr, int L, int R) { // process表示对对范围内的数组进行排序
        if (L == R) return; // 递归出口，也是特殊情况的处理
        int mid = L + ((R - L) >> 1); // 防止下标越界
        process(arr, L, mid); // 分别对左右两边进行排序
        process(arr, mid + 1, R); // 中值靠左所以不会越界
        merge(arr, L, mid, R);
    }

    private void merge (int[] arr, int L, int mid ,int R) {
        int len = R - L + 1;
        int[] help = new int[len]; // 创建辅助数组
        int i = L;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= R)  help[k ++] = arr[i] < arr[j] ? arr[i ++] : arr[j ++]; // 在归并排序的变式中有时需要考虑等号是否取到
        while (i <= mid) help[k ++] = arr[i ++];
        while (j <= R) help[k ++] = arr[j ++];
        for (int p = 0;p < len;p ++) {
            arr[L + p] = help[p];
        }
    }
}


