package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    public static ArrayList<String> DFSSearch(HashMap<String, ArrayList<String>> graph, String startNode){
        // 방문한 거 표시하는 List
        ArrayList<String> visited = new ArrayList<>();
        // 방문이 필요한 List
        ArrayList<String> needVisit = new ArrayList<>();
        // 방문이 필요한 List를 넣어줌.
        needVisit.add(startNode);
        while(needVisit.size() > 0){
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)){
                needVisit.addAll(graph.get(node));
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

        System.out.println(DFSSearch(graph,"A"));
    }
}
