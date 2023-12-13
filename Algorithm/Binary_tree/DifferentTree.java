package Algorithm.Binary_tree;
import Tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class DifferentTree {

    /**
     * 思路：
     *  通过中序遍历，保证上一个节点的值永远小于下一个节点的值即可
     * @param root
     * @return
     */
    private int preVal = Integer.MIN_VALUE;
    public boolean searchTree(TreeNode root) {
        if(root == null) return true;
        boolean isSer = searchTree(root.left);
        if(!isSer) return false; // 将不是搜索二叉树的信息往上返回
        if(root.val >= preVal) {
            preVal = root.val; // 中序遍历保证下一个节点的值永远比上一个节点的值大
        } else return false;
        return searchTree(root.right);
    }

    /**
     * 思路：
     * （可以通过列出所有可能的情况进行分析，然后发现有两种情况可以合并成一种情况）
     *      在发现第一个节点的左树或者右树有null后，后续的节点中左右子树都应该是null
     *      否则就是非完全二叉树
     * @param root
     * @return
     */
    public boolean checkBST(TreeNode root) {
        if(root == null) return true;
        boolean isEnd = false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if(isEnd && (node.left != null || node.right != null)) return false;
            if(!isEnd && (node.left == null || node.right == null)) isEnd = true;
            if(node.left != null) deque.add(node.left);
            if(node.right != null) deque.add(node.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100, new TreeNode(96, new TreeNode(90), new TreeNode(97)), new TreeNode(101));
        System.out.println(new DifferentTree().searchTree(root));;
    }
}
