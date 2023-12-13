package Algorithm.Binary_tree;

import Tools.ListNode;

/**
 * 题目：
 *  打印一条对着n次后的纸条的凹凸情况
 */
public class OrigamiProblem {
    public static void main(String[] args) {
        printProcess(1, 8, true);
    }

    // 观察折痕规律发现当前折痕的左边折痕是凸折痕，右边折痕是凹折痕
    static void printProcess(int i, int n, boolean isConvex) {
        if(i > n) return ;
        printProcess(i + 1, n, isConvex);
        // 采用中序遍历
        System.out.print(isConvex ? "凸" : "凹");
        printProcess(i + 1, n, !isConvex);
    }
}
