package pr_10_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public static class Edge implements Comparable<Edge>{
        Integer distance;
        String node1;
        String node2;
        Edge(Integer distance, String node1, String node2){
            this.distance = distance;
            this.node1 = node1;
            this.node2 = node2;
        }
        @Override
        public int compareTo(Edge o){
            return this.distance - o.distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "distance=" + distance +
                    ", node1='" + node1 + '\'' +
                    ", node2='" + node2 + '\'' +
                    '}';
        }
    }
    public static ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges){
        Edge currentEdge, podEdge, adjacentEdge;
        HashMap<String,ArrayList<Edge>> adjacentEdges = new HashMap<>();
        ArrayList<Edge> mst = new ArrayList<>();
        ArrayList<String> connectEdge = new ArrayList<>();
        ArrayList<Edge> candidateEdges = new ArrayList<>();
        for (int i = 0; i<edges.size(); i++){
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.node1)){
                adjacentEdges.put(currentEdge.node1,new ArrayList<>());
            }
            adjacentEdges.get(currentEdge.node1).add(new Edge(currentEdge.distance, currentEdge.node1, currentEdge.node2));
            if (!adjacentEdges.containsKey(currentEdge.node2)){
                adjacentEdges.put(currentEdge.node2,new ArrayList<>());
            }
            adjacentEdges.get(currentEdge.node1).add(new Edge(currentEdge.distance, currentEdge.node2, currentEdge.node1));
        }
        connectEdge.add(startNode);
        candidateEdges = adjacentEdges.getOrDefault(startNode,new ArrayList<>());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < candidateEdges.size(); i++){
            priorityQueue.add(candidateEdges.get(i));
        }
        while ( priorityQueue.size() > 0 ){
            podEdge = priorityQueue.poll();
            if (!connectEdge.contains(podEdge.node2)){
                connectEdge.add(podEdge.node2);
                mst.add(podEdge);
                for (int i = 0; i<adjacentEdges.get(podEdge.node2).size(); i++){
                    adjacentEdge = adjacentEdges.get(podEdge.node2).get(i);
                    if (!connectEdge.contains(adjacentEdge.node2)){
                        priorityQueue.add(adjacentEdge);
                    }
                }
            }
        }
        return mst;
    }
    public static void main(String[] args) {
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
        System.out.println(primFunc("A", edges));
    }
}
