package Algorithm.Binary_Search;

/**
 * 题目：
 *  寻找目标数字第一次出现的下标
 */

public class TheFinalTargetNum {
    public static int FindFirstPoint(int[] arr, int tar) {
        int i = 0, j = arr.length - 1;
       while(i < j ){
            int k = i + ((j - i) >> 1); // 防止超过int的范围
            if(arr[k] < tar) i = k + 1;
            else j = k - 1;
        }
        return i;
    }

    public static int FindLastPoint(int[] arr, int tar) {
        int i = 0, j = arr.length - 1;
        while(i < j ){
            int k = i + ((j - i) >> 1); // 防止超过int的范围
            if(arr[k] <= tar) i = k + 1;
            else j = k - 1;
        }
        return j;
    }
}
/*
    总结：
        取目标数的最左边还是最右边，关键在于在等于目标数的时候，是让i动还是让j动
 */