package pr_10_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkStarPath {
    public static class Edge implements Comparable<Edge> {
        String vertex;
        Integer distance;
        Edge(Integer distance, String vertex){
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Edge o){
            return this.distance - o.distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex='" + vertex + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }
    public static HashMap<String,Integer> DijkStarFunc(HashMap<String,ArrayList<Edge>> graph, String startVertex){
        HashMap<String,Integer> distance = new HashMap<>();
        String currentVertex, adjacentVertex;
        Integer currentDistance, adjacentDistance;
        Edge edge, adjacentEdge;
        for (String key : graph.keySet()){
            distance.put(key,Integer.MAX_VALUE);
        }
        distance.put(startVertex, 0);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(0,startVertex));
        while( priorityQueue.size() > 0 ){
            edge = priorityQueue.poll();
            currentVertex = edge.vertex;
            currentDistance = edge.distance;
            if (currentDistance > distance.get(currentVertex)){
                continue;
            }
            for (int i = 0; i < graph.get(currentVertex).size(); i++){
                adjacentEdge = graph.get(currentVertex).get(i);
                adjacentVertex = adjacentEdge.vertex;
                adjacentDistance = adjacentEdge.distance + currentDistance;
                if (adjacentDistance < distance.get(adjacentVertex)){
                    priorityQueue.add(new Edge(adjacentDistance,adjacentVertex));
                    distance.put(adjacentVertex,adjacentDistance);
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
        System.out.println(DijkStarFunc(graph,"A"));
    }
}
