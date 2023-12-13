package Algorithm.Binary_tree;

import Tools.TreeNode;

/*
    二叉树递归套路：
        明确函数的返回信息
        明确所有的可能性（当不满足哪些条件时，返回什么值）

        将递归函数本身看作实现该功能的黑盒，并分别从左树和右树上获取相应的信息
        重新组合这些信息返回给上一级

        注意：
            1.无论是左树还是右数都必须满足同一条套路
            2.递归出口处的值要设立好
 */

// 案例：判断平衡二叉树
public class Trick {
    private static class ReturnDate { // 传递给上一级的信息
        int high; // 当前节点的高度
        boolean isBalance;  // 当前节点是否平衡
        ReturnDate (int high, boolean isBalance){
            this.high = high;
            this.isBalance = isBalance;
        }
    }

    private ReturnDate process(TreeNode root) { // 无论对哪个节点，要保证功能是同样的
        if(root == null) return new ReturnDate(0, true);
        ReturnDate l = process(root.left); // 分别获取左右树的信息
        ReturnDate r = process(root.right); // 假设方法是黑箱，可以获取左右节点的信息
        return new ReturnDate(
                Math.max(l.high, r.high),  // 返回上一级所需要的信息
                l.isBalance && r.isBalance && Math.abs(l.high - r.high) < 2 // 不满足的所有可能性：左节点或者右节点不是BT（平衡树），当前节点的左右高度差超过2
        ); // 整理信息，返回给上一级


    }

    public boolean checkBalanceTree(TreeNode root) {
        return process(root).isBalance;
    }

    /**
     * 题目：
     *  返回第一个祖先节点
     *
     * 分析：
     *  一共两种可能性：
     *      1.o1或者o2其中一个就是节点的祖先
     *      2.o1或者o2的祖先是一个非自身的祖先
     * 遍历二叉树，直到为空或者找到目标节点时返回
     * 通过判断，如果找到目标节点返回节点
     */
    public TreeNode process(TreeNode root, TreeNode o1, TreeNode o2) {
        if(root == null || root == o1 || root == o2) return root;// base case:如果遇到目标节点和null就返回（相当于循环的终止条件）
        TreeNode left = process(root.left, o1, o2); // 从左树和右树上要信息（是否右o1和o2的存在）
        TreeNode right = process(root.right, o1, o2); // 左右树一直调用直到碰到base case返回
        if(left != null && right != null) return root; // 解决可能性2：如果左右树分支上发现有o1和o2的存在就返回
        return left != null ? left : right; // 将信息往上抛
    }
    /*
        第二种解法思路：
            通过一次遍历用hashMap记录二叉树的每个节点父亲值
            准备hashSet将其中一个目标节点的所有父亲值存入，对另一个节点向上寻找，
            第一个再hashSet中的值就是公共祖先
     */



}
