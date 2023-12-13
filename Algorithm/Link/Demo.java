package Algorithm.Link;

import Tools.ListNode;

public class Demo {
    public static void main(String[] args) {
        new Solution().sortList(ListNode.generateLink(new int[]{4,2,1,3}));
    }



}

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode help = head;
        int size = 1;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        process(help, size, null);
        return help;
    }

    public void process(ListNode node, int size, ListNode end) {
        if (size <= 1) return;
        int mid = size / 2;
        ListNode help = node;
        for (int i = 0; i < mid; i++) node = node.next;
        process(help, mid, node);
        process(node, size - mid, end);
        merge(help, node, end);
    }

    public void merge(ListNode l, ListNode r, ListNode end) {
        ListNode help = new ListNode(-1);
        ListNode mid = r;
        while (l != mid && r != end) {
            if (l.val > r.val) {
                r = r.next;
                help.next = r;
            } else {
                help.next = l;
                l = l.next;
            }
        }
        if (l != mid) {
            while (l.next != mid) l = l.next;
            l.next = end;
        }


    }
}
