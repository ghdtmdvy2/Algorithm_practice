package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int[][][] tomato;
    static int[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int dz[] = {1, -1};
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int cnt = 0;
    public static void dfs(){
        while(!queue.isEmpty()){
            int current[] = queue.remove();
            int z = current[0];
            int x = current[1];
            int y = current[2];
            for (int i = 0; i<4; i++){
                int vx = dx[i] + x;
                int vy = dy[i] + y;
                if (vx < 0 || vy < 0 || vx >= tomato[0].length || vy >= tomato[0][0].length){
                    continue;
                }
                if (visited[z][vx][vy] == 0 && tomato[z][vx][vy] == 0) {
                    visited[z][vx][vy] = visited[z][x][y] + 1;
                    tomato[z][vx][vy] = 1;
                    queue.add(new int[]{z,vx,vy});
                }
            }
            for (int i = 0; i<2; i++){
                int vz = dz[i] + z;
                if (vz < 0 || vz >= tomato.length){
                    continue;
                }
                if (visited[vz][x][y] == 0 && tomato[vz][x][y] == 0) {
                    visited[vz][x][y] = visited[z][x][y] + 1;
                    tomato[vz][x][y] = 1;
                    queue.add(new int[]{vz,x,y});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];
        visited = new int[H][N][M];
        for (int i = 0; i<H; i++){
            for (int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k<M; k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for (int i = 0; i<H; i++){
            for (int j = 0; j<N; j++){
                for (int k = 0; k<M; k++){
                    if (tomato[i][j][k] == 1) {
                        queue.add(new int[]{i,j,k});
                    }
                }
            }
        }
        dfs();
        int answer = 0;
        outer:
        for (int i = 0; i<H; i++){
            for (int j = 0; j<N; j++){
                for (int k = 0; k<M; k++){
                    if (tomato[i][j][k] == 0) {
                        answer = -1;
                        break outer;
                    }
                    if (answer < visited[i][j][k]){
                        answer = visited[i][j][k];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
