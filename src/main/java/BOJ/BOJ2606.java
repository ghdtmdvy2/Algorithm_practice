package BOJ;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2606
class BOJ2606 {
    public static int searchDFS(HashMap<Integer,ArrayList<Integer>> graph, Integer startNode){
        ArrayList<Integer> visitedNode = new ArrayList<>();
        ArrayList<Integer> needVisitNode = new ArrayList<>();
        needVisitNode.add(startNode);

        while(needVisitNode.size() > 0){
            Integer worm = needVisitNode.remove(needVisitNode.size() - 1);
            if (!visitedNode.contains(worm)){
                visitedNode.add(worm);
                if (graph.get(worm) != null){
                    needVisitNode.addAll(graph.get(worm));
                }
            }
        }
        return visitedNode.size() - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int worm = Integer.parseInt(br.readLine());
        int computer = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i<computer; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            if (graph.get(com1) == null && graph.get(com2) == null){
                graph.put(com1, new ArrayList<>(Arrays.asList(com2)));
                graph.put(com2, new ArrayList<>(Arrays.asList(com1)));
            } else if (graph.get(com1) == null){
                graph.put(com1, new ArrayList<>(Arrays.asList(com2)));
                graph.get(com2).add(com1);
            } else if (graph.get(com2) == null){
                graph.put(com2, new ArrayList<>(Arrays.asList(com1)));
                graph.get(com1).add(com2);
            } else {
                graph.get(com1).add(com2);
                graph.get(com2).add(com1);
            }
        }
        bw.write(String.valueOf(searchDFS(graph,1)));
        bw.flush();
        bw.close();
    }
}