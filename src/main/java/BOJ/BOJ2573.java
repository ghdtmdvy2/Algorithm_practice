package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {
    static int ice[][];
    static int visited[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static int bfs(int startX, int startY, int chk) {
        visited[startX][startY] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        int cnt = 0;
        while(!queue.isEmpty()) {
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            for (int i = 0; i<4; i++){
                int vx = dx[i] + cx;
                int vy = dy[i] + cy;
                if (vx < 0 || vy < 0 || vx >= ice.length || vy >= ice[0].length) {
                    continue;
                }
                if (chk == 0) {
                    if (ice[vx][vy] > 0) {
                        visited[vx][vy] = 1;
                        cnt++;
                        ice[vx][vy]--;
                    }
                    if (visited[vx][vy] == 0 && ice[vx][vy] == 0) {
                        visited[vx][vy] = 1;
                        queue.add(new int[]{vx,vy});
                    }
                } else {
                    if (visited[vx][vy] == 0 && ice[vx][vy] != 0) {
                        visited[vx][vy] = 1;
                        queue.add(new int[]{vx,vy});
                    }
                }

            }
        }
        if (cnt > 0) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int i = 0;
        int cnt = 0;
        int time = 0;
        while(true) {
            for (int j = 0; j<M; j++){
                if (visited[i][j] == 0 && ice[i][j] == 0) {
                    cnt = cnt + bfs(i,j,0);
                }
            }
            i++;
            if (i >= N && cnt > 0) {
                time++;
                i = 0;
                cnt = 0;
                visited = new int[N][M];
                int bigIce = 0;
                for (int k = 0; k<N; k++){
                    for (int l = 0; l<M; l++){
                        if (visited[k][l] == 0 && ice[k][l] > 0) {
                            bigIce++;
                            bfs(k,l,1);
                        }
                    }
                }
                if (bigIce >= 2) {
                    break;
                }
                visited = new int[N][M];
            } else if (i >= N) {
                time = 0;
                break;
            }
        }
        System.out.println(time);
    }
}
