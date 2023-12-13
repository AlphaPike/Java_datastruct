package Algorithm.sort.Quick_sort;
import Tools.Util;

import java.util.Arrays;

/**
 * 求数组前m个最小数
 */
public class Trick {
    public static int[] spilt(int[] arr, int l, int r, int m) {
        if(r <= l) return null;
        int k = arr[l],lp = l, rp = r - 1, p = l;
        while(p <= rp) {
            if(arr[p] == k) p ++;
            else if(arr[p] < k) Util.swap(arr, lp ++, p ++);
            else if(arr[p] > k) Util.swap(arr, rp --, p);
        }
        rp ++;
        if(lp <= m && m <= rp) {
            return Arrays.copyOf(arr, m);
        } else if(m >= rp) {
            return spilt(arr, rp, r, m);
        } else {
            return spilt(arr, l, lp, m);
        }
    }

    public static void main(String[] args) {
        int[] x = spilt(new int[]{1, 4, 5, 2, 3, 10, 32, 1, 23, 4, 5, 65, 6, 43, 2, 1, 2,3 ,2, 43, 34, 3}, 0, 21, 5);
        for(int p : x) System.out.println(p);

    }
}
