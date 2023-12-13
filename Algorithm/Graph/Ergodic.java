package Algorithm.Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class Ergodic {
    // 注意：图的dfs也可以使用递归的常用套路
    public static void recursionOfDFS(Node node, HashSet<Node> set) {
        // 子路径被访问过，则返回
        if(set.contains(node)) return;
        set.add(node);
        /*
            第一次进入该节点时的coding语句
         */
        System.out.println(node.value);
        // 开始对子路径进行访问
        for(Node next : node.nexts) {
            recursionOfDFS(next, set);
            // 每一条子路径访问完成后的返回该节点
        }
    }

    public static void bfs(Node node) {
        if(node == null) return ;
        LinkedList<Node> queue = new LinkedList<>(); // 广用队列深用栈
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            /*
                访问节点时的coding语句
             */
            for(Node next : cur.nexts) { // 遍历此节点的所哟子节点，将所有未访问过的节点加入
                if(!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
    }

    /*
        模拟递归
        dfs：一条路穷走，到尽头后返回上一层对上一层的另一条路进行穷走
     */
    public static void dfs(Node node) {
        if(node == null) return ;
        LinkedList<Node> stack = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        /*
            第一次抵达的coding
         */
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            /*
                递归多次抵达时的代码(意义不大)
             */
            for(Node next : cur.nexts) { // 遍历子节点，寻找未访问过的节点
                if(!set.contains(next)) {
                    stack.push(cur); // 重新压入该节点，以便返回的时候可以继续访问为访问过的路径
                    stack.push(next);
                    set.add(next);
                    /*
                        第一次到达的coding
                     */
                    break;
                }
            }
        }
    }
}
