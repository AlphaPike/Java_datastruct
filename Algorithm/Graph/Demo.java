package Algorithm.Graph;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.nexts.add(node2);
        node1.nexts.add(node3);

        node2.nexts.add(node6);
        node2.nexts.add(node5);
        node2.nexts.add(node4);

        node3.nexts.add(node2);
        node3.nexts.add(node1);

        Ergodic.recursionOfDFS(node1, new HashSet<>());
    }
}

/*
    Kruskal算法：解决最小生成树问题
    说明：此处使用简化并查集
    未测试！！！！！！！！！！！！！！！！！！！！！！！！！
 */
class Kruskal {
    // 集合类，包含所有集合
    private static class Sets{
        HashMap<Node, HashSet<Node>> sets;
        // 判断两个节点是否属于同一个集合
        public boolean isSameSet(Node from, Node to) {
            return sets.get(from).contains(to);
        }

        // 合并两个集合
        public void union(Node from, Node to) {
            HashSet<Node> set = sets.get(from);
            set.addAll(sets.get(to)); // 存在问题，无法将先前的点，归并为同一个集合
            sets.put(to, set);
        }

        // 将所有点分别创立集合
        public Sets(List<Node> nodes) {
            sets = new HashMap<>();
            for(Node node : nodes) {
                HashSet<Node> set = new HashSet<>();
                set.add(node);
                sets.put(node, set);
            }
        }
    }

    // 返回能够使图成为最小生成树的全部边
    public static Set<Edge> kruskalMST(Graph graph) {
        // 小根堆，保证每次取出的边权值最小
        PriorityQueue<Edge> heap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        Sets sets = new Sets((List<Node>) graph.nodes.values());
        HashSet<Edge> result = new HashSet<>();
        while(!heap.isEmpty()) {
            Edge edge = heap.poll();
            if(!sets.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                sets.union(edge.from, edge.to);
            }

        }
        return result;
    }
}

/*
    Prim算法：解决最小生成树
    要求：无向图
 */
class Prim {
    public static Set<Edge> PrimMST(Graph graph) {
        HashSet<Node> set = new HashSet<>();
        PriorityQueue<Edge> heap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        HashSet<Edge> res = new HashSet<>();
        // 解决非连通图问题
        for(Node node : graph.nodes.values()) {
            // 过滤不是同一张图的节点
            if(set.contains(node)) continue;
            // 初始化
            for(Edge edge : node.edges) {
                heap.offer(edge);
            }
            set.add(node);

            while(!heap.isEmpty()) {
                Edge edge = heap.poll();
                // 依次取最小的边，加上后判断所包含的节点会不会组成环
                if(!set.contains(edge.to)) {
                    for(Edge e : edge.to.edges) {
                        heap.offer(e);
                    }
                    res.add(edge);
                    set.add(edge.to);
                }
            }
        }
        return res;
    }
}

/*
    Dijkstra算法：求单元最短路径算法
    说明：可以使用堆的改写进行优化
    未测试！！！！！！！！！！！！！！！！！！！！！！！！！
 */
class Dijkstra {
    // 此处可使用改造堆进行优化
    private static Node getMinNode(HashMap<Node, Integer> distinctMap, HashSet<Node> selectedSet) {
        int min = Integer.MAX_VALUE;
        Node minNode = null;
        for(Map.Entry<Node, Integer> entry : distinctMap.entrySet()) {
            Node node = entry.getKey();
            int distinct = entry.getValue();
            if(!selectedSet.contains(node) && distinct < min) {
                minNode = node;
                min = distinct;
            }
        }
        return minNode;
    }

    public static HashMap<Node, Integer> dijkstraMST(Node head) {
        if(head == null) return null;
        HashMap<Node, Integer> distinctMap = new HashMap<>(); // 用来存储初始节点到目标节点的距离
        HashSet<Node> selectedSet = new HashSet<>();
        distinctMap.put(head, 0);

        Node minNode = head;
        while(minNode != null) {
            int weight = distinctMap.get(minNode);
            for(Edge edge : minNode.edges) {
                Node toNode = edge.to;
                int temp = distinctMap.containsKey(toNode) ? distinctMap.get(edge.to) : Integer.MAX_VALUE; // 如果节点不存在，则两点间的距离为无穷
                if(weight + edge.weight < temp) distinctMap.put(toNode, weight + edge.weight); // 更新相邻路径的节点，使它保持从当前节点出发最小
            }
            selectedSet.add(minNode);
            minNode = getMinNode(distinctMap, selectedSet); // 获取最小节点
        }
        return distinctMap;
    }
}