package Tools;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public TreeNode right;
    public TreeNode left;
    public int val;

    /**
     * 二叉树的序列化和反序列化
     */
    public static Integer[] serialize(TreeNode root) {
        List<Integer> help = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if(node != null) {
                help.add(node.val);
                deque.add(node.left);
                deque.add(node.right);
            } else {
                help.add(null);
            }
        }
        return help.toArray(new Integer[0]);
    }

    public static TreeNode deserialize(Integer[] arr) {
        if(arr[0] == null) return null;
        Deque<TreeNode> deque = new LinkedList<>();

        int k = 0;
        TreeNode head = generateTree(arr[k ++]);
        deque.add(head);
        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            node.left = k >= arr.length ? null : generateTree(arr[k ++]);
            node.right = k >= arr.length ? null : generateTree(arr[k ++]);
            if(node.left != null) deque.add(node.left);
            if(node.right != null) deque.add(node.right);

        }
        return head;
    }

    private static TreeNode generateTree(Integer x) {
        if(x == null) return null;
        return new TreeNode(x);

    }






    // 直观打印二叉树
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    /**
     * 相当于逆向的中序遍历（右->中->左）
     * （之所以选择中序遍历，而不是前序/后序，是因为中序遍历的顺序就是将二叉树直接"拍扁"得到的顺序，因此90°旋转后，正好是按行打印的顺序）
     */
    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len); // 递归遍历右子树
        String val = to + head.val + to; // 处理并打印根节点
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len); // 递归遍历左子树
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    // 直观打印二叉树测试代码
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(-222222222);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(Integer.MIN_VALUE);
        head.right.left = new TreeNode(55555555);
        head.right.right = new TreeNode(66);
        head.left.left.right = new TreeNode(777);
        printTree(head);

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.left.left.right = new TreeNode(7);
        printTree(head);

        head = new TreeNode(1);
        head.left = new TreeNode(1);
        head.right = new TreeNode(1);
        head.left.left = new TreeNode(1);
        head.right.left = new TreeNode(1);
        head.right.right = new TreeNode(1);
        head.left.left.right = new TreeNode(1);
        printTree(head);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.right = right;
        this.left = left;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}



