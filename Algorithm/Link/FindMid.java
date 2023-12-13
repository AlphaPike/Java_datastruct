package Algorithm.Link;

import Tools.ListNode;

public class FindMid {
    public static void main(String[] args) {
        ListNode head = ListNode.generateLink(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(findRight(head).val);
    }

    public static ListNode findLeft(ListNode head) {
        if(head == null) return null;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) fast = fast.next;  // 特殊情况的处理：只有一个元素的时候
        }
        return slow;
    }

    public static ListNode findRight(ListNode head) {
        if(head == null) return null;
        ListNode fast = head, slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) fast = fast.next;
        }
        return slow;
    }
}
