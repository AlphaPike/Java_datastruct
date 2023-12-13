package Algorithm.Link;
import Tools.ListNode;
/**
 * 题目：
 *  1.判断链表是否有环的存在，有的话返回True，没有的话返回False
 *  2.证明两个链表是否相交
 */
public class FastAndSlowPoint { // 注：快慢指针不会大幅度降低效率
    /*
        所有可能出现的情况：
            1.如果链表中存在环的情况，则一定不会到头
            2.通过分类三种情况：判断是否有环
        分析方法：通过罗列所有情况观察特点
     */
    static ListNode find(ListNode h1, ListNode h2){
        ListNode cur1 = circularCheck(h1);
        ListNode cur2 = circularCheck(h2);
        if(cur1 == null && cur2 == null) return noLoop(h1, h2, null);
        else if(cur1 == null || cur2 == null) return null;
        else {
            if(cur1 == cur2) return noLoop(h1, h2, cur1);
            else return null;
        }

    }

    static ListNode circularCheck(ListNode head) { // 查找入环的首个节点
        ListNode fast = head;
        ListNode slow = head;
        do { // 快指针和慢指针如果能相等就说明有环（最多不会超过两圈）
            if(fast.next == null || fast.next.next == null) return null; // 判断
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);
        fast = head;
        while(fast != slow) { // 再次遇到的时候为环的第一个节点
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // end表示末尾节点，如果存在环的话，入环节点为末尾节点
    private static ListNode noLoop(ListNode h1, ListNode h2, ListNode end) { // 第一种情况：无环
        if(h1 == end || h2 == end) return null;
        int count = 0;
        ListNode cur1 = h1, cur2 = h2;
        while(cur1.next != end) {count ++; cur1 = cur1.next;}
        while(cur2.next != end) {count --; cur2 = cur2.next;}
        if(cur1 != cur2) return null; // 如果相交最后一个节点一定会相等
        if(count < 0) {cur1 = h2; cur2 = h1;} // 通过count的值来判断两个链表的长短，并且总保持长的赋值给cur1
        count = Math.abs(count);
        while(count > 0) {count --; cur1 = cur1.next;}
        while(cur1 != cur2) { // 第一个相交的节点就是相交的节点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

}

/*
    结论：
        第一次相遇后，快指针从起点一次走一步
        慢指针一次走一步，第二次相遇一定是在起点位置（可以证明）
 */