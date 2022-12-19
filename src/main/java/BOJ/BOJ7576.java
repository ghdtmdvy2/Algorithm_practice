package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int visited[][];
    static int tomato[][];
    static Queue<int[]> queue = new LinkedList<>();
    public static void bfs(){

        int cnt = 1;
        while (!queue.isEmpty()){
            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= visited.length || vy >= visited[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && tomato[vx][vy] == 0) {
                    visited[vx][vy] = 1;
                    tomato[vx][vy] = tomato[cx][cy] + 1;
                    queue.add(new int[]{vx,vy});

                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if(tomato[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        bfs();
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){

                if (tomato[i][j] - 1 > max){
                    max = tomato[i][j] - 1;
                }
                if (tomato[i][j] == 0){
                    cnt++;
                    break;
                }
            }
        }

        if (cnt >= 1){
            System.out.println(-1);
        } else {
            System.out.println(max);
        }

    }
}
