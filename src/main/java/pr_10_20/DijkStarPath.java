package pr_10_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkStarPath {
    public static class Edge implements Comparable<Edge>{
        String vertex;
        Integer distance;

        Edge(Integer distance, String vertex){
            this.vertex = vertex;
            this.distance = distance;
        }


        @Override
        public int compareTo(Edge o) {
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
    public static HashMap<String, Integer> DijkStarFunc (HashMap<String, ArrayList<Edge>> graph, String startVertex){
        HashMap<String, Integer> distance = new HashMap<>();
        Edge adjacentEdge;
        String adjacentVertex, currentVertex;
        Integer adjacentDistance, currentDistance;
        for (String key : graph.keySet()){
            distance.put(key,Integer.MAX_VALUE);
        }
        distance.put(startVertex,0);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(0,startVertex));
        while (priorityQueue.size() > 0){
            Edge edge = priorityQueue.poll();
            currentVertex = edge.vertex;
            currentDistance = edge.distance;
            if (currentDistance > distance.get(currentVertex)){
                continue;
            }
            for (int i = 0; i < graph.get(currentVertex).size(); i++){
                adjacentEdge = graph.get(currentVertex).get(i);
                adjacentVertex = adjacentEdge.vertex;
                adjacentDistance = adjacentEdge.distance + currentDistance;
                if (distance.get(adjacentVertex) > adjacentDistance){
                    priorityQueue.add(new Edge(adjacentDistance,adjacentVertex));
                    distance.put(adjacentVertex,adjacentDistance);
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<DijkStarPath.Edge>> graph = new HashMap<String, ArrayList<DijkStarPath.Edge>>();
        graph.put("A", new ArrayList<DijkStarPath.Edge>(Arrays.asList(new DijkStarPath.Edge(8, "B"), new DijkStarPath.Edge(1, "C"), new DijkStarPath.Edge(2, "D"))));
        graph.put("B", new ArrayList<DijkStarPath.Edge>());
        graph.put("C", new ArrayList<DijkStarPath.Edge>(Arrays.asList(new DijkStarPath.Edge(5, "B"), new DijkStarPath.Edge(2, "D"))));
        graph.put("D", new ArrayList<DijkStarPath.Edge>(Arrays.asList(new DijkStarPath.Edge(3, "E"), new DijkStarPath.Edge(5, "F"))));
        graph.put("E", new ArrayList<DijkStarPath.Edge>(Arrays.asList(new DijkStarPath.Edge(1, "F"))));
        graph.put("F", new ArrayList<DijkStarPath.Edge>(Arrays.asList(new DijkStarPath.Edge(5, "A"))));
        System.out.println(DijkStarPath.DijkStarFunc(graph,"A"));
    }


}
