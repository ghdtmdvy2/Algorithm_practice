package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalPath {
    // 부모 노드를 알려주는 것
    // 첫번째가 자식 노드, 두번째가 부모 노드라고 전재
    public static HashMap<String, String> parent = new HashMap<>();
    // 자신의 노드가 rank 가 몇인지.
    public static HashMap<String, Integer> rank = new HashMap<>();

    public ArrayList<Edge> KruskalFuc(ArrayList<String> vertices, ArrayList<Edge> edges){
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;
        // makeSet 메서드를 통해 초기값 설정.
        for (int i = 0; i < vertices.size(); i++){
            makeSet(vertices.get(i));
        }
        // edges 를 정렬 -> Comparable 상속 받아 가중치로 정렬 기준으로 가져왔기 때문에 sort 로 정렬이 가능함.
        Collections.sort(edges);
        for (int i = 0; i < edges.size(); i++){
            // 현재 Edge 를 가져옴.
            currentEdge = edges.get(i);
            // 사이클 확인 하는 부분
            // 만약에 같은 경우( 루트 노드가 같은 경우 ) 사이클이 존재하기 때문에 mst 에 add를 해주지 않음.
            if (find(currentEdge.nodeU) != find(currentEdge.nodeV)) {
                // 루트 노드가 같지 않기 때문에 ( == 사이클이 돌지 않기 때문에 ) 트리를 합쳐줌.
                union(currentEdge.nodeV, currentEdge.nodeU);
                // 결과값을 저장.
                mst.add(currentEdge);
            }
        }
        return mst;
    }
    public static class Edge implements Comparable<Edge> {
        // 가중치
        Integer weight;
        // 첫번째 노드
        String nodeV;
        // 두번째 노드
        String nodeU;
        Edge(Integer weight, String nodeV, String nodeU){
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }
        // 내림차순 정의.
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", nodeV='" + nodeV + '\'' +
                    ", nodeU='" + nodeU + '\'' +
                    '}';
        }
    }
    // 1. 초기화 = 개별 원소 집합으로 만드는 것
    public static void makeSet(String node){
        // 초기로는 자기를 가리켜 root 노드로 결정
        parent.put(node,node);
        // 초기 값이므로 rank 를 0으로.
        rank.put(node, 0);
    }
    // 2. union = 원소 집합을 합쳐주는 것
    public static void union(String nodeV, String nodeU){
        // nodeV의 루트 노드를 반환
        String root1 = find(nodeV);
        // nodeU의 루트 노드를 반환
        String root2 = find(nodeU);
        // rank 를 확인하여 어떤 것을 루트 노드로 결정할 지 선택.
        if (rank.get(root1) > rank.get(root2)){
            parent.put(root2,root1);
        } else {
            parent.put(root1,root2);
            if (rank.get(root1) == rank.get(root2)){
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }
    // 3. find = 루트 노드를 찾아 사이클이 있는 지 확인. + path compression 알고리즘을 추가하여 루트 노드와 rank 를 낮추게 해주는 것
    // 3-1. rank 가 같은 경우 하나의 rank 를 올려서 root 노드로 선정.
    // 3-2. rank 가 다른 경우 높은 rank 를 root 노드로 선정.
    public static String find(String node){
        // 만약에 루트 노드가 같은지 아닌지 확인
        // 부모 노드는 루트 노드가 자기를 가리킴.
        if (parent.get(node) != node){
            // 재귀 함수를 통해 부모 노드의 rank 를 줄여주는 용도.
            // 즉 path compression 을 해주는 곳.
            parent.put(node,find(parent.get(node)));
        }
        // 부모 노드를 반환.
        return parent.get(node);
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
        KruskalPath kObject = new KruskalPath();
        System.out.println(kObject.KruskalFuc(vertices,edges));

    }
}
