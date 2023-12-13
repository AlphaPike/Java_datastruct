package Algorithm.Binary_Search;

public class BSearch {
    public static int bSearch(int[] arr, int tar) {
        for(int i = 0,j = arr.length - 1;i < j; ){
            int k = (i + j) / 2;
            if(arr[k] == tar) return k;
            if(arr[k] < tar) i = k + 1;
            else j = k - 1;
        }
        return -1;
    }
}
