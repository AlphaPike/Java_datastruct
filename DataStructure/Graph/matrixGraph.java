package DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;

// 无向图:用邻接矩阵表示
public class matrixGraph {
    // vertexList 顶点集合
    // edges 邻接矩阵 表示是否相连
    // numOfEdges 边的数量
     ArrayList<String> vertexList;
     int[][] edges;
     int numOfEdges;

    // 测试
    public static void main(String[] args) {
        String[] vertex = {"A", "B", "C", "D"};
        matrixGraph graph = new matrixGraph(4);
        for(String s : vertex) {
            graph.insertVertexList(s);
        }
        graph.insertEdge("A","B",1);
        graph.insertEdge("A","D",1);
        graph.insertEdge("C","B",1);
        graph.showGraph();
    }


    /**
     * 添加节点,默认和所有节点没有连接
     * @param vertex 插入的节点名
     */
    public void insertVertexList(String vertex) {
        if(vertexList.size() + 1 > edges.length) throw new RuntimeException("图以满，该版本不支持自动扩容");
        vertexList.add(vertex);
    }

    /**
     * 添加节点的同时连接节点
     * @param vertex 添加的节点
     * @param to 添加的节点连接到哪个节点
     * @param weight 两节点之间的权值
     */
    public void insertVertexList(String vertex, String to, int weight) {
        insertVertexList(vertex);
        insertEdge(vertex, to, weight);
    }

    /**
     * 返回是否存在该节点，如果存在返回true，否则返回false
     * @param vertex 节点名称
     */
    public boolean isExist(String vertex) {
        return vertexList.contains(vertex);
    }

    // 添加节点与节点的关系
    public void insertEdge(String v1, String v2, int weight) {
        int p1, p2;
        if((p1 = vertexList.indexOf(v1)) == -1 || (p2 = vertexList.indexOf(v2)) == -1) throw new RuntimeException("不存在该节点");
        edges[p1][p2] = weight;
        edges[p2][p1] = weight;
        numOfEdges ++;
    }

    // 获取两个图的权值
    public int getWeight(String v1, String v2) {
        int p1, p2;
        if((p1 = vertexList.indexOf(v1)) == -1 || (p2 = vertexList.indexOf(v2)) == -1) throw new RuntimeException("不存在该节点");
        return edges[p1][p2];
    }

    // 显示图
    public void showGraph() {
        System.out.print("   ");
        for (String s : vertexList) {
            System.out.print(s + ",");
        }
        System.out.println();
        for(int i = 0;i < vertexList.size();i ++) {
            System.out.print(vertexList.get(i));
            System.out.println(Arrays.toString(edges[i]));
            System.out.println();
        }

    }

    // 获得边的数目
    public int getNumOfEdge() {
        return numOfEdges;
    }

    // 获取存入节点的数目
    public int getNumOfVertex() {
        return vertexList.size();
    }


    public matrixGraph(String[] vertexList, int[][] edges) {
        this.vertexList = new ArrayList<>(Arrays.asList(vertexList));
        this.edges = Arrays.copyOf(edges, edges.length);
    }


    // 设置矩阵的总大小
    public matrixGraph(int size) {
        vertexList = new ArrayList<>(size);
        edges = new int[size][size];
    }
}
