package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {
    static List<Integer> tree[];
    static int visited[];
    static int parent[];
    public static void bfs(int start) {
        visited[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int c = queue.remove();
            for (int t : tree[c]) {
                if (visited[t] == 0){
                    visited[t] = 1;
                    parent[t] = c;
                    queue.add(t);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for (int i = 1; i<N+1; i++){
            tree[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        parent = new int[N+1];
        for (int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        bfs(1);
        for (int i = 2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }
}
