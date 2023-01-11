package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13549 {
    static int dx[] = {2,-1,1};
    static int visited[] = new int[100001];
    static int ans = Integer.MAX_VALUE;
    static int ansCnt = 0;
    public static void bfs(int start, int dest, int cnt){
        visited[start] = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start,cnt});
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int c[] = queue.remove();
            int cx = c[0];
            int cCnt = c[1];
            if (cx == dest) {
                ans = Math.min(cCnt,ans);
                if (ans == cCnt) {
                    ansCnt++;
                }
            }
            for (int i = 0; i<3; i++){
                int v = dx[i] + cx;
                if (i == 0) {
                    v = dx[i] * cx;
                }
                if (v < 0 || v >= visited.length || cx == v) {
                    continue;
                }
                if (visited[v] == 0) {
                    if (!(v == dest)) {
                        list.add(v);
                    }
                    if (i == 0) {
                        queue.add(new int[]{v,cCnt});
                    } else {
                        queue.add(new int[]{v,cCnt+1});
                    }
                }
            }
            for (int i = 0; i< list.size(); i++){
                visited[list.get(i)] = 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bfs(S,B,0);
        System.out.println(ans);

    }
}
