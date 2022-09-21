package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public static ArrayList<String> BFS_search(HashMap<String, ArrayList<String>> graph, String startNode){
        // 방문한 노드(큐) ( 이미 방문 한 노드인지 check 하는 용도 )
        ArrayList<String> visited = new ArrayList<>();
        // needVisit 방문이 필요한 노드(큐)
        ArrayList<String> needVisit = new ArrayList<>();
        // 첫 노드는 꼭 알려줘야해서 파라미터로 받아옴.
        needVisit.add(startNode);
        while (needVisit.size() > 0){
            // 방문이 필요한 노드를 제거 해주어 방문한 노드(visited)에다가 저장해주기 위해서 반환값을 'node' 값에다가 저장해줌
            // 왜냐하면 방문한 노드는 또 방문할 필요가 없기 때문에.
            String node = needVisit.remove(0);
            // 이미 방문한 노드인지 체크
            if (!visited.contains(node)) {
                // 파라미터로 받아온 노드를 needVisit에다가 넣어줌.
                needVisit.addAll(graph.get(node));
                // 방문한 노드라고 저장.
                visited.add(node);
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        System.out.println(BFS_search(graph,"A"));
    }
}
