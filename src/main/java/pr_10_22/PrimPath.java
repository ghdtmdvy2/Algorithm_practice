package pr_10_22;

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
                    ", nodeU='" + node1 + '\'' +
                    ", nodeX='" + node2 + '\'' +
                    '}';
        }
    }
    public static ArrayList<Edge> primFunc(String startNode,ArrayList<Edge> edges){
        Edge currentEdge;
        HashMap<String, ArrayList<Edge>> adjacentNode = new HashMap<>();
        ArrayList<String> connectedEdge = new ArrayList<>();
        ArrayList<Edge> candidateEdges = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        ArrayList<Edge> adjacentEdges = new ArrayList<>();
        Edge popEdge, adjacentEdge;
        for (int i = 0; i<edges.size(); i++){
           currentEdge = edges.get(i);
           if (!adjacentNode.containsKey(currentEdge.node1)){
               adjacentNode.put(currentEdge.node1, new ArrayList<>());
           }
           adjacentNode.get(currentEdge.node1).add(new Edge(currentEdge.distance, currentEdge.node1, currentEdge.node2));
           if (!adjacentNode.containsKey(currentEdge.node2)){
               adjacentNode.put(currentEdge.node2, new ArrayList<>());
           }
           adjacentNode.get(currentEdge.node2).add(new Edge(currentEdge.distance, currentEdge.node2, currentEdge.node1));
        }
        connectedEdge.add(startNode);
        candidateEdges = adjacentNode.getOrDefault(startNode,new ArrayList<>());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < candidateEdges.size(); i++){
            priorityQueue.add(candidateEdges.get(i));
        }

        while( priorityQueue.size() > 0 ){
            popEdge = priorityQueue.poll();
            if(!connectedEdge.contains(popEdge.node2)){
                connectedEdge.add(popEdge.node2);

                mst.add(popEdge);
                adjacentEdges = adjacentNode.getOrDefault(popEdge.node2,new ArrayList<>());
                for (int i = 0; i<adjacentEdges.size(); i++){
                    adjacentEdge = adjacentEdges.get(i);
                    if (!connectedEdge.contains(adjacentEdge.node2)){
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
