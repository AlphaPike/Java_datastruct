package MyHomework.Binary_Tree;

import Tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class demo {
    public static void main(String[] args) {
        // 通过反序列化建树
        TreeNode root = TreeNode.deserialize(new Integer[]{1, 3, null, 4, 5});
        System.out.println("中序遍历输出字符串");
        dfs(root);
        System.out.println();
        System.out.println("宽度优先遍历字符串");
        bfs(root);
    }

    public static void dfs(TreeNode root) {
        if(root == null) return ;
        dfs(root.left);
        System.out.print(root.val);
        dfs(root.right);
    }

    public static void bfs(TreeNode root) {
        if(root == null) return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
}
