package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2644 {
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static int visited[];
    static int parentVisited[];
    static HashMap<Integer,Integer> depth = new HashMap<>();
    static int cnt = 2;
    public static int parentSearch(Integer startNode){
        List<Integer> needVisit = new ArrayList<>();
        needVisit.add(startNode);
        while(needVisit.size() > 0){
            Integer pop = needVisit.remove(needVisit.size() - 1);
            if (depth.get(pop) == 0){
                return pop;
            }
            if (parentVisited[pop] == 0){
                parentVisited[pop] = 1;
                if (graph.get(pop) != null){
                    for (Integer key : graph.get(pop)){
                        if (depth.get(key) == 0){
                            return key;
                        } else {
                            needVisit.add(key);
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void DFS(Integer startNode){
        List<Integer> needVisit = new ArrayList<>();
        needVisit.add(startNode);
        while(needVisit.size() > 0){
            Integer pop = needVisit.remove(needVisit.size() - 1);
            if (visited[pop] == 0){
                visited[pop] = 1;
                if (graph.get(pop) != null){
                    for (Integer key : graph.get(pop)){
                        if (visited[key] == 1){
                            if (depth.get(key) == null){
                                depth.put(key, 0);
                            }
                            depth.put(pop,depth.get(key) + 1);
                        } else {
                            needVisit.add(key);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int searchU = Integer.parseInt(st.nextToken());
        int searchV = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        visited = new int[N+1];
        parentVisited = new int[N+1];
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (i == 0){
                visited[u] = 1;
                visited[v] = 1;
                graph.put(u,new ArrayList<>(Arrays.asList(v)));
                graph.put(v,new ArrayList<>(Arrays.asList(u)));
                depth.put(u,0);
                depth.put(v,1);
            }
            else if (graph.get(u) == null && graph.get(v) == null){
                graph.put(u,new ArrayList<>(Arrays.asList(v)));
                graph.put(v,new ArrayList<>(Arrays.asList(u)));
            } else if (graph.get(u) == null){
                graph.put(u,new ArrayList<>(Arrays.asList(v)));
                graph.get(v).add(u);
            } else if (graph.get(v) == null){
                graph.put(v,new ArrayList<>(Arrays.asList(u)));
                graph.get(u).add(v);
            } else {
                graph.get(v).add(u);
                graph.get(u).add(v);
            }
        }
        for (int i = 1; i<=N; i++){
            if (visited[i] == 0){
                DFS(i);
            }
        }
        if (parentSearch(searchU) == parentSearch(searchV)){
            bw.write(String.valueOf(depth.get(searchU) + depth.get(searchV)));
        } else {
            bw.write(String.valueOf(-1));
        }
        bw.flush();
        bw.close();
    }
}
