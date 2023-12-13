package Algorithm.Link;

import Tools.ListNode;

/*
    前言：由于链表没有下标，所以获取不同位置的数需要有一些技巧

    其中快慢指针就是技巧之一
 */
public class DifferentFASPoint {
    // 1.在偶数数组下获取中点偏左的元素
    int getHalfLeft(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    // 2.获取偶数数组下标中点偏右的下标
    int getHalfRight(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast.next != null) fast = fast.next;
        }
        return slow.val;
    }

    /*
        总结：想要获取离中点偏右多远的元素就加多少组fast.next.....next = null
     */
}
