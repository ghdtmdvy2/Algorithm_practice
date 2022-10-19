package Algorithm.pr_10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    public static ArrayList<String> DFSSearch(HashMap<String, ArrayList<String>> graph, String startNode){
        ArrayList<String> needVisitNode = new ArrayList<>();
        ArrayList<String> visitedNode = new ArrayList<>();
        needVisitNode.add(startNode);
        while(needVisitNode.size() > 0){
            String node = needVisitNode.remove(needVisitNode.size() - 1);
            if (!visitedNode.contains(node)){
                visitedNode.add(node);
                needVisitNode.addAll(graph.get(node));
            }
        }
        return visitedNode;
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
