package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11724 {
    static ArrayList<Integer> visited = new ArrayList<>();
    static ArrayList<Integer> needVisit = new ArrayList<>();
    static HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
    public static void DFS(){
        while(needVisit.size() > 0 && visited.size() > 0){
            Integer pop = needVisit.remove(needVisit.size() - 1);
            if(visited.contains(pop)){
                visited.remove(pop);
                if (graph.get(pop) != null){
                    needVisit.addAll(graph.get(pop));
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (M == 0){
            System.out.println(1);
            return;
        }
        for(int i = 1; i<=N; i++){
            set.add(i);
        }
        for (int i = 0; i<M; i++){

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (graph.get(u) == null && graph.get(v) == null){
                graph.put(u, new ArrayList<>(Arrays.asList(v)));
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
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            visited.add(iter.next());
        }
        int answer = 0;

        while (visited.size() > 0 && visited.size() > 0){
            needVisit.add(visited.get(0));
            answer++;
            DFS();
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
