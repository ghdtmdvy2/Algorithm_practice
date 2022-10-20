package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkStarPath {
    public static class Edge implements Comparable<Edge>{
        String vertex;
        Integer distance;
        Edge(Integer distance,String vertex){
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
    public static HashMap<String,Integer> DijkStarFunc(HashMap<String, ArrayList<Edge>> graph, String startNode){
        String currentNode, adjacentVertex;
        Integer currentDistance, adjacentDistance;
        ArrayList<Edge> adjacentNode;
        // 1. 첫 초기 값으로 startNode 제외하고 inf(무한대) 값 넣어주기
        // distances 변수는 startNode 로부터 최소 가중치(최소 거리)를 저장하는 변수 값이다.
        HashMap<String, Integer> distances = new HashMap<>();
        // 1-1 startNode 제외하고 inf 에 넣기 위해서 모든 값들을 다 무한대로 넣어줌.
        for (String key : graph.keySet()){
            distances.put(key,Integer.MAX_VALUE);
        }
        // 1-1. 첫 초기 값 넣어주기.
        distances.put(startNode,0);
        // 2. 처음 시작하는 것 우선순위 큐에 넣기.
        // 현재 가장 짧은 거리를 가진 노드 정보를 위해서 우선 순위 큐에 넣어줌.
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(0,startNode));

        // 알고리즘 시작.
        while(priorityQueue.size() > 0){
            // 3-1. 우선순위 큐에 저장되어 있는 Edge를 출력
            Edge edge = priorityQueue.poll();
            // 3-1-1. 우선순위 큐에 저장되어 있는 Node 저장
            currentNode = edge.vertex;
            // 3-1-1. 우선순위 큐에 저장되어 있는 distance 저장
            currentDistance = edge.distance;
            // 3-2. 만약에 저장 되어있는 distances 부분에서 더 큰 값이 있으면 계산 스킵 ( 불필요한 계산 스킵 )
            if (distances.get(currentNode) < currentDistance){
                continue;
            }
            // 4. 현재 노드에서의 인접한 노드들을 가져오기.
            for (int i = 0; i<graph.get(currentNode).size(); i++){
                // 인접한 노드들 가져오기 ArrayList<Edge>로 되어 있음.
                adjacentNode = graph.get(currentNode);
                adjacentVertex = adjacentNode.get(i).vertex;
                // 인접한 노드의 가중치 가져오기
                adjacentDistance = adjacentNode.get(i).distance + currentDistance;

                // 인접한 노드의 가중치와 현재 저장 되어 있는 distances 와 비교하여 값이 더 작으면 업데이트 해주고, 우선순위 큐에 넣어주기.
                if (adjacentDistance < distances.get(adjacentVertex) ) {
                    // distances 업데이트 해주기
                    distances.put(adjacentVertex,adjacentDistance);
                    // 우선순위 큐에 업데이트 된 Edge 넣어주기
                    priorityQueue.add(new Edge(adjacentDistance,adjacentVertex));
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
        System.out.println(DijkStarPath.DijkStarFunc(graph,"A"));
    }
}
