package Algorithm.sort.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：
 *  给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Tricks {
    /**
     * 注意：
     *  在面试中，面试官更倾向于让更面试者自己实现一个堆
     *  「堆排」在很多大公司的面试中都很常见
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator<Integer>(){ // 匿名内部类
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        }); // 系统提供的优先级队列：默认小根堆（需通过传比较器的方式来改变堆的模式）
        for(int i = 0;i < nums.length;i ++) {
            heap.add(nums[i]);
        }
        for(int i = 0;i < k - 1;i ++) {
            heap.poll();
        }
        return heap.poll();
    }
}
