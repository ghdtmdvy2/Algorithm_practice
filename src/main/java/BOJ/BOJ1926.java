package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int visited[][];
    static int picture[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int max = 0;
    public static void bfs(int startX, int startY, int cnt) {
        visited[startX][startY] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY,cnt});
        int cCnt = 1;
        while(!queue.isEmpty()){
            int remove[] = queue.remove();
            int cx = remove[0];
            int cy = remove[1];
            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= visited.length || vy >= visited[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && picture[vx][vy] == 1) {
                    cCnt++;
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cCnt + 1});
                }
            }
        }
        max = Math.max(max,cCnt);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        picture = new int[N][M];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int pCnt = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (picture[i][j] == 1 && visited[i][j] == 0) {
                    pCnt++;
                    bfs(i,j,1);
                }
            }
        }
        System.out.println(pCnt);
        System.out.println(max);
    }
}
