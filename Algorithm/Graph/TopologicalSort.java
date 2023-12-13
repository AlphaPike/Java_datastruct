package Algorithm.Graph;

import java.util.*;

public class TopologicalSort {
    // 拓扑排序，解决执行顺序问题
    public static List<Node> SortedTopology(Graph graph) {
        // 记录各点的入度，防止对原点的更改
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 记录执行步骤中不需要依赖其他执行步骤的节点，将它们依次弹出
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 统计图中各节点的入度
        for(Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if(node.in == 0) {
                zeroInQueue.offer(node);
            }
        }
        List<Node> ans = new LinkedList<>();
        // 清除末端点造成的影响：将他们的直接关系的节点的入度减掉，并将成为末端执行步骤的重新加入到队列中
        while(!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            ans.add(cur);
            for(Node next : cur.nexts) {
                int in = inMap.get(next);
                if(in == 0) continue;
                if(--in == 0) zeroInQueue.offer(next);
                inMap.put(next, in);
            }
        }
        return ans;
    }
}
