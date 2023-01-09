package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2644 {
    static List<Integer> tree[];
    static int visited[];
    static int ans = -1;
    public static void bfs(int start, int destination, int cnt) {
        if (start == destination) {
            ans = cnt;
        }
        for (int c : tree[start]) {
            if (visited[c] == 0) {
                visited[c] = 1;
                bfs(c,destination,cnt + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[N+1];
        visited = new int[N+1];
        for (int i = 0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        bfs(start,destination,0);
        System.out.println(ans);
    }
}
