package pr_10_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalPath {
    static HashMap<String, String> parent = new HashMap<>();
    static HashMap<String, Integer> rank = new HashMap<>();
    public static class Edge implements Comparable<Edge>{
        Integer distance;
        String nodeU;
        String nodeX;
        Edge(Integer distance, String nodeU, String nodeX){
            this.distance = distance;
            this.nodeU = nodeU;
            this.nodeX = nodeX;
        }

        @Override
        public int compareTo(Edge o){
            return this.distance - o.distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "distance=" + distance +
                    ", nodeU='" + nodeU + '\'' +
                    ", nodeX='" + nodeX + '\'' +
                    '}';
        }
    }
    public static void makeSet(String node){
        parent.put(node, node);
        rank.put(node,0);
    }
    public static String find(String node){
        if (parent.get(node) != node){
            parent.put(node,find(parent.get(node)));
        }
        return parent.get(node);
    }
    public static void union(String nodeU, String nodeX){
        String rootNodeU = find(nodeU);
        String rootNodeX = find(nodeX);
        if (rank.get(rootNodeU) < rank.get(rootNodeX)){
            parent.put(rootNodeU,rootNodeX);
        } else {
            parent.put(rootNodeX,rootNodeU);
            if (rank.get(rootNodeU) == rank.get(rootNodeX)){
                rank.put(rootNodeU, rank.get(rootNodeU) + 1);
            }
        }
    }
    public static ArrayList<Edge> KruskalFuc(ArrayList<String> vertices, ArrayList<Edge> edges){
        Edge currentEdge;
        String currentNodeU,currentNodeX;
        ArrayList<Edge> mst = new ArrayList<>();
        for (int i = 0; i<vertices.size(); i++){
            makeSet(vertices.get(i));
        }
        Collections.sort(edges);
        for (int i = 0; i<edges.size(); i++){
            currentEdge = edges.get(i);
            currentNodeU = currentEdge.nodeU;
            currentNodeX = currentEdge.nodeX;
            if (find(currentNodeU) != find(currentNodeX)){
                union(currentNodeU, currentNodeX);
                mst.add(currentEdge);
            }
        }
        return mst;
    }
    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));
        System.out.println(KruskalFuc(vertices,edges));

    }
}
