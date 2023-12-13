package Algorithm.dynamic_programming;

public class Trick01 {

    /**
     *  题型1：单数组遍历查找
     *  查找最长递增子序列
     *      状态：以每个数作为结尾的最长递增子序列
     */
    public static int longest_incremental_substring(int[] arr) {
        if(arr.length == 0) return -1;
        int len = 1;
        int maxLen = 0;

        /*
            状态：以每个数为结尾获取最长上升子序列
            状态转移：
         */
        for(int i = 1;i < arr.length;i ++) {
            if(arr[i] > arr[i - 1]) len ++;
            else len = 1;
            if(len > maxLen) maxLen = len;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int x = longest_incremental_substring(new int[]{1,2, 3, 1, 2, 1});
        System.out.println(x);
    }
}

/**
 * 题型2：双数组遍历查找
 * 查找最长公共子串、
 *  分析：
 *
 *  思路：
 *      状态：对于每一个字符串组合中最长的公共子串
 *      阶段：两组串中的某两个数的位置的下标
 *      状态转移方程：
 *          如果两个数相等：状态值 = 上一个状态值 + 本阶段的字符
 *          如果两数不等：状态值 = 上一个状态值 +
 */
class Trick02{
    public static String longest_common_substring(String s1, String s2) {
        // 状态：对于每一个字符串组合中最长的公共子串
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];

        // 设置边界条件：0子串和任意长度的公共子串为""
        for(int i = 0;i < s1.length();i ++) dp[i][0] = "";
        for(int j = 0;j < s1.length();j ++) dp[0][j] = "";

        // i、j表示从左边开始的字符个数
        for(int i = 1;i <= s1.length();i ++) {
            for(int j = 1;j <= s2.length();j ++) {
                /*
                 *      状态转移方程：
                 *          如果两个数相等：状态值 = 上一个状态值 + 本阶段的字符
                 *          如果两数不等：状态值 = 之前状态的最大值
                 *
                 *      有点类似路径问题：将左边和上面的值选取更大的，作为新的状态值
                 */
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i);
                else dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        return dp[s1.length() + 1][s2.length() + 1];
    }
}

/**
 * 最佳加法表达式：有一个由1~9组成的数字串。问如果将m个加号插入到这个数字串中，在各种可能形成的表达式中，值最小的那个表达式的值是多少
 */
class Trick03{

}