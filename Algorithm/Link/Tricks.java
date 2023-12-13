package Algorithm.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目：
 *  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Tricks {

    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
        }
    }

    // 通过哈希表实现：哈希表的时间复杂度可看作o(1)但会占用更多的空间
    // 通过哈希表讲链表转换成类似数组一样可以直接查询的结构
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 题目：逆序打印链表
     *  解法1：利用递归会再次回到自己的性质
     *  解法2：利用Stack先进后出的特性
     */


}
