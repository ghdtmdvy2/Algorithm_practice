package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int safeArea[][];
    static int area[][];
    static int visited[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void bfs(int sx,int sy){
        visited[sx][sy] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
        while(!queue.isEmpty()) {
            int current[] = queue.remove();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy+ dy[i];
                if (vx < 0 || vy < 0 || vx >= area.length || vy >= area[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && area[vx][vy] == 0) {
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int rain = 0;
        safeArea = new int[N][N];
        area = new int[N][N];
        visited = new int[N][N];
        int ans = 0;
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                safeArea[i][j] = Integer.parseInt(st.nextToken());
                if (rain < safeArea[i][j]) {
                    rain = safeArea[i][j];
                }
            }
        }
        for (int i = 1; i<=rain; i++){
            for (int j = 0; j<N; j++){
                for (int k = 0; k<N; k++){
                    if (safeArea[j][k] <= i) {
                        area[j][k] = 1;
                    }
                }
            }
            int cnt = 0;
            for (int j = 0; j<N; j++){
                for (int k = 0; k<N; k++){
                    if (visited[j][k] == 0 && area[j][k] == 0) {
                        cnt++;
                        bfs(j,k);
                    }
                }
            }
            ans = Math.max(cnt,ans);
            area = new int[N][N];
            visited = new int[N][N];
        }
        if (ans == 0) {
            System.out.println(1);
        } else {
            System.out.println(ans);
        }
    }
}
