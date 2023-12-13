package Algorithm.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 万能图模板:在使用时可能需要设置转换函数,将提供的图结构转换成该图结构
 * 邻接表版本
 */
public class Graph {
    // nodes中的两个参数分别表示: 每个节点的编号,和节点对象
    public HashMap<Integer, Node> nodes;
    // edges中表的值表示边的集合
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

class Node {
    // 表示该节点所携带的值
    public int value;
    // 表示该节点的入度    即:有多少节点指向它
    public int in;
    // 表示该节点的出度    即:有多少节点被它指向
    public int out;
    // 表示该节点直接指向的邻居节点
    public ArrayList<Node> nexts;
    // 表示属于该节点的边  即:由该节点出发指向其他节点的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}

class Edge {
    // 表示边的权重
    public int weight;
    // 表示边的起点
    public Node from;
    // 表示边的指向
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
