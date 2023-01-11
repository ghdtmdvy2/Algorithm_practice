package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    static int visited[];
    static int d[];
    static int ans = -1;
    public static void bfs(int total, int cur, int starlink, int up, int down){
        visited[cur] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cur,0});
        while(!queue.isEmpty()){
            int current[] = queue.remove();
            int c = current[0];
            int cCnt = current[1];
            if (c == starlink) {
                ans = cCnt;
                return;
            }
            for (int i = 0; i<2; i++){
                int v = d[i] + c;
                if (i == 1) {
                    v = c - d[i];
                }
                if (v <= 0 || v >= visited.length) {
                    continue;
                }
                if (visited[v] == 0) {
                    visited[v] = 1;
                    queue.add(new int[]{v,cCnt+1});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        visited = new int[F+1];
        d = new int[2];
        d[0] = U;
        d[1] = D;
        bfs(F,S,G,U,D);
        if (ans == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(ans);
    }
}
