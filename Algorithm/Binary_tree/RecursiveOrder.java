package Algorithm.Binary_tree;
import Tools.TreeNode;

import java.util.*;

public class RecursiveOrder {
    static void ergodic(TreeNode root) {
        if(root == null) return;
        // 第一次进入：先序(深度优先遍历)
        ergodic(root); // 可以简单的理解成，对当前节点而言：左边遍历完毕，现在回到这里（递归的关键：理解方法的含义，并套用方法的含义）
        // 第二次进入：中序
        ergodic(root);
        // 第三次进入：后序
    }
    static void prefaceLoop(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>(); // 此处，双向链表也可以实现栈的功能
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 1
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
    }

    /**
     * 思路：
     *  将每一条左节点看作一列，每一个节点的右节点看作一行
     *  利用栈结构保证节点能够逆序输出
     * @param root
     */
    static void inorderLoop(TreeNode root) {
        if(root == null) return ;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) { // 如果root到头就
                stack.push(root);  // 存储这一列的节点方便逆序输出
                root = root.left;
            } else {
                root = stack.pop();
                /* *************
                      code
                 **************/
                root = root.right;
            }
        }
    }

    /**
     * 思路：
     *  利用栈数据结构逆序输出“头右左”
     * @param root
     */
    static void posOrderLoop(TreeNode root) {
        if(root == null) return ;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> st = new Stack<>(); // 用st栈来记录“头右左遍历的每个节点”
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            st.push(node);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        while(!st.isEmpty()) { // 输出从st中记录的节点
            TreeNode node = st.pop();
            /* ****
                code
             */
        }
    }

    /**
     * 思路：
     *  通过队列来记录下一行的节点顺序（有点类似深度优先遍历，只不过一个逆序输出，一个正序输出）
     * @param root
     */
    static void breathFirstSearch(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>(); // 双向链表可以用来模拟队列
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            /*
                code 此处写对宽度遍历中每个节点的操作
             */
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
    }
    // -----------------实战----------------
    /*
     * 题目：
     *  求二叉树的最大宽度
     */

    /**
     * 思路：
     *  通过宽度优先遍历遍历每一行节点的同时，统计每一行的节点个数
     *  通过HashMap记录每一个节点的行数（坐标）来确定当前节点是第几行
     * @param root
     * @return
     */
    static int maxBreath1(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();

        queue.add(root);
        int curLine = 0; // 记录当前行号
        int curMount = 0; // 记录当前行数的节点数量
        int max = -1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(curLine == hashMap.get(node)) curMount ++;
            else { // 不相等说明到了下一行
                curLine ++;
                if(max < curMount) max = curMount;
                curMount = 1; // 重置当前行数量
            }
            if(node.left != null) {
                queue.add(node.left);
                hashMap.put(node.left, curLine + 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                hashMap.put(node.right, curLine + 1);
            }
        }
        return max;
    }

    /**
     * 思路：
     *  存储每一行的最后一个节点，遇到最后一个节点就进行结算（判断是否是最大值）
     */
    static int maxBreath2(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode end = root;
        int max = -1;
        int curMount = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curMount ++;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(node == end) { // 说明已经到节点的末尾
                if(!queue.isEmpty()) end = queue.peekLast(); // 获取刚加入的元素：
                if(curMount > max) max = curMount;
                curMount = 0;
            }
        }
        return max;
    }

}

