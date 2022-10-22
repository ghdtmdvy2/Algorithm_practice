package pr_10_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkStarPath {
    public static class Edge implements Comparable<Edge>{
        Integer distance;
        String vertex;
        Edge(Integer distance, String vertex){
            this.distance = distance;
            this.vertex = vertex;
        }
        @Override
        public int compareTo(Edge o){
            return this.distance - o.distance;
        }
    }
    public static HashMap<String, Integer> DijkStarFunc(HashMap<String,ArrayList<Edge>> graph, String startNode){
        HashMap<String, Integer> distances = new HashMap<>();
        Edge currentEdge;
        String currentVertex, adjacentVertex;
        Integer currentDistance, adjacentDistance;
        Edge adjacentEdge;
        for (String key : graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(startNode,0);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(0, startNode));

        while ( priorityQueue.size() > 0 ){
            currentEdge = priorityQueue.poll();
            currentVertex = currentEdge.vertex;
            currentDistance = currentEdge.distance;
            if (distances.get(currentVertex) < currentDistance){
                continue;
            }
            for (int i = 0; i < graph.get(currentVertex).size(); i++){
                adjacentEdge = graph.get(currentVertex).get(i);
                adjacentVertex = adjacentEdge.vertex;
                adjacentDistance = adjacentEdge.distance + currentDistance;
                if (distances.get(adjacentVertex) > adjacentDistance){
                    priorityQueue.add(new Edge(adjacentDistance,adjacentVertex));
                    distances.put(adjacentVertex,adjacentDistance);
                }
            }
        }
        return distances;
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
