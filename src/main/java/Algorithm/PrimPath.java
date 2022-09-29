package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public static class Edge implements Comparable<Edge>{
        // 노드의 가중치.
        Integer weight;
        // 현재 자기 노드를 뜻함.
        String node1;
        // 자기와 연결 된 노드를 뜻함.
        String node2;
        Edge(Integer weight, String node1, String node2){
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        // 우선 순위큐에 넣을 때 내림차순으로 정렬하기 위한 오버라이드.
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", node1='" + node1 + '\'' +
                    ", node2='" + node2 + '\'' +
                    '}';
        }
    }
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();
        // 이 부분은 해당 존재하는 노드에서의 인접한 리스트들을 모두다 저장하는 곳. <- key 값을 저장하는 곳.
        for (int i = 0; i<edges.size(); i++){
            // 현재 Edge를 가져온다.
            currentEdge = edges.get(i);
            // 그냥 단순히 인접한 HashMap을 초기화 해주는 곳이다.
            // 만약에 노드(edges)가 "A", "B", "C" 가 있다면
            // A 라는 Key에 Value가 비어있고, B 라는 Key에 Value가 비어있고, C 라는 Key에 Value가 비어있는 것이다.
            if(!adjacentEdges.containsKey(currentEdge.node1)){
                adjacentEdges.put(currentEdge.node1, new ArrayList<>());
            }
            if(!adjacentEdges.containsKey(currentEdge.node2)){
                adjacentEdges.put(currentEdge.node2, new ArrayList<>());
            }
        }
        // 이 부분은 해당 존재하는 노드에서의 인접한 리스트들의 value 값을 모두다 저장하는 곳. <- value 값을 저장하는 곳.
        for (int i = 0; i<edges.size(); i++){
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            // node1(첫번째 파라미터)은 자기 노드, node2(두번째 파라미터)는 자기와 연결된 노드라고 생각해야한다.
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }
        // 알고리즘 시작
        // connectedNodes 는 탐색 하는 곳 ( key 값 가져오는 부분 )
        // 해당 key 값 초기화 한 것을 가져오는 곳.
        connectedNodes.add(startNode);
        // candidateEdgeList 는 탐색 하는 곳 ( value 값 가져오는 부분 )
        // 해당 value 값 초기화 한 것을 가져오는 곳.
        // getOrDefault은 해당 되는 인접한 Edge value 값이 없으면 에러가 안생기게 null 값을 넣는 것.
        candidateEdgeList = adjacentEdges.getOrDefault(startNode,new ArrayList<>());
        // 우선순위 큐는 가중치가 낮은 값을 노드를 꺼내기 위한 것.
        priorityQueue = new PriorityQueue<>();
        for (int i = 0; i<candidateEdgeList.size(); i++){
            priorityQueue.add(candidateEdgeList.get(i));
        }
        // 이제 가중치가 인접하면서 낮은 값부터 우선순위 큐에서 꺼내어 주기.
        while(priorityQueue.size() > 0){
            poppedEdge = priorityQueue.poll();
            // 현재 연결 된(node2)를 가져와 이 노드가 결과 값에(mst[최소신장트리])에 포함 되어있는 지 확인.
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 결과 값에(mst[최소신장트리]) 포함되어 있지 않다면 추가.
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1,poppedEdge.node2));
                // 연결된 노드들을 다시 새로 갱신 해야하기 때문에 인접한 노드들을 우선순위 큐에 넣어줌.
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2,new ArrayList<>());
                for (int i = 0; i < adjacentEdgeNodes.size(); i++){
                    // 인접한 노드들을 가져오게 만듦.
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);
                    // 우선 순위 큐에 그냥 넣는 것보다 만약 연결된 노드가 사이클이 생기는지 체크 여부.
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));
        PrimPath pObject = new PrimPath();
        System.out.println(pObject.primFunc("A", myedges));
    }
}