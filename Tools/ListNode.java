package Tools;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public static ListNode generateRandomLink(int minSize, int maxSize) {
        return generateLink(new GenerateRandomArr(minSize, maxSize).generate());
    }

    public static ListNode generateLink(int[] arr) {
        ListNode head = new ListNode(); // 生成 下标为-1的链表，这样就能一直对next进行修改而不是自身
        ListNode node = head;
        for (int x : arr) {
            node.next = new ListNode(x);
            node = node.next;
        }
        return head.next;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
