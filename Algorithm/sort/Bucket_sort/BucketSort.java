package Algorithm.sort.Bucket_sort;


import Tools.GenerateRandomArr;

public class BucketSort {
    // 包装类
    public static void bucketSort (int[] arr, int L, int R) {
        decSort(arr, L, R, maxBits(arr, L, R));
    }

    private static int maxBits(int[] arr, int L , int R) {
        int max = Integer.MIN_VALUE;
        for(int i = L;i < R;i ++) {
            if(arr[i] > max) max = arr[i];
        }
        int count = 0;
        while(max != 0) {
            max /= 10;
            count ++;
        }
        return count;
    }
    /**
     * 优化说明：
     *      通过利用词频表记录某一位上有多少个数字，再通过逆序遍历出捅的方式，减少了队列的使用，优化了内存
     *
     * 逆序遍历模拟优先级队列说明：
     *      假设上次已经做好了数据前一个位的排序（递归的黑箱技巧）
     *      count统计的结果是当前位上有多少个数据小于等于这个数
     *
     *      现在要做的是对arr中的每一个数进行定位
     *      arr中最后一个数表示前一位最大的数据，所以这个数在当前位的所有数中最大的一个数，所以count就表示比它小的数有多少个
     *      通过count来直接定位当前数的位置（有点像荷兰国旗问题）
     *
     * 基于数据状况的比较：
     *      利用数据的性质进行排序，利用词频表避免了数据的比较，但这也意味着只能对有进制的数字进行排序
     *
     * L 包括 R 不包括 --> 满足统一性要求：此组数据做的排序不影响下一次做的排序（无后效性原则）
     * @param arr 要排序的数组
     * @param L 数组的左边界
     * @param R 数组的右边界
     * @param digit 最大元素位数
     */
    private static void incSort(int[] arr, int L, int R, int digit) {
        final int radix = 10; // 表示对十进制的数字进行排序
        int[] bucket = new int[R - L]; // 辅助数组：用于暂存某一阶段的排序
        int[] count; // 用于存储词频
        for(int d = 0;d < digit;d ++) {
            count = new int[radix];
            for(int i = L;i < R;i ++) count[getDigit(arr[i], d)] ++;// 创建当前位的词频表
            for(int i = 1;i < radix;i ++) count[i] += count[i - 1]; // 转换词频表为小和表
            for(int i = R - 1;i >= L;i --) bucket[-- count[getDigit(arr[i], d)]] = arr[i]; // 定位当前位的每一组数据中每一个数的位置  注意要先减！！！！
            for(int i = 0;i < bucket.length;i ++) arr[L + i] = bucket[i]; // 讲排好序的当前位传给arr
        }
    }

    private static void decSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int[] bucket = new int[R - L];
        int[] count;
        for(int d = 0;d < digit;d ++) {
            count = new int[radix];
            for(int i = L;i < R;i ++) count[getDigit(arr[i], d)] ++;
            for(int i = radix - 2;i >= 0;i --) count[i] += count[i + 1]; // 转词频表为逆序大和表，来保证逆序遍历的每个数都是这组数的最后一个数（最小的数）
            for(int i = R - 1;i >= L;i --) bucket[-- count[getDigit(arr[i], d)]] = arr[i];
            for(int i = 0;i < bucket.length;i ++) arr[L + i] = bucket[i];
        }
    }

    private static int getDigit(int x, int index) {
        x /= Math.pow(10, index);
        return x %= Math.pow(10, index + 1);
    }
}
//
class demo {
    public static void main(String[] args) {
        GenerateRandomArr gra =  new GenerateRandomArr(5, 13, 10, 20);
        int[] arr = gra.generate();
        BucketSort.bucketSort(arr, 0, arr.length);
        for(int x:arr) System.out.print(x + " ");
    }
}