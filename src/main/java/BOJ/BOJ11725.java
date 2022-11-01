package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    public static void DFS(Integer startNode){
        needVisit.add(startNode);
        answer.put(startNode,0);
        while(needVisit.size() > 0){
            Integer pop = needVisit.remove(needVisit.size() - 1);
            if (visited[pop] == 0){
                visited[pop] = 1;
                if (graph.get(pop) != null){
                    for (Integer key : graph.get(pop)){
                        if (visited[key] == 1){
                            answer.put(pop,key);
                        } else {
                            needVisit.add(key);
                        }
                    }
                }
            }
        }
    }
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static Integer visited[];
    static List<Integer> needVisit = new ArrayList<>();
    static HashMap<Integer,Integer> answer = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        visited = new Integer[N+1];
        for (int i=1; i<=N; i++){
            visited[i] = 0;
        }
        for (int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (graph.get(v) == null && graph.get(u) == null){
                graph.put(u,new ArrayList<>(Arrays.asList(v)));
                graph.put(v,new ArrayList<>(Arrays.asList(u)));
            } else if (graph.get(v) == null){
                graph.put(v,new ArrayList<>(Arrays.asList(u)));
                graph.get(u).add(v);
            } else if (graph.get(u) == null){
                graph.put(u,new ArrayList<>(Arrays.asList(v)));
                graph.get(v).add(u);
            } else {
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }
        DFS(1);
        for (int i = 2; i<=N; i++){
            bw.write(String.valueOf(answer.get(i))+"\n");
        }
        bw.flush();
        bw.close();
    }
}
