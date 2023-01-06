package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    static int wall[][];
    static int visited[][][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static int bfs(int startX, int startY, int wr, int mCnt){
        visited[wr][startX][startY] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY,wr,mCnt});
        while(!queue.isEmpty()) {
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            int cwr = c[2];
            int cmCnt = c[3];
            if (cx == wall.length - 1 && cy== wall[0].length - 1) {
                return cmCnt;
            }
            for (int i = 0; i<4; i++){
                int vx = dx[i] + cx;
                int vy = dy[i] + cy;
                if (vx < 0 || vy < 0 || vx >= wall.length || vy >= wall[0].length ) {
                    continue;
                }
                if (wall[vx][vy] == 0 && visited[cwr][vx][vy] == 0) {
                    visited[cwr][vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cwr,cmCnt + 1});
                }
                if (cwr == 0 && wall[vx][vy] == 1 && visited[1][vx][vy] == 0) {
                    visited[1][vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cwr+1,cmCnt + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        wall = new int[N][M];
        visited = new int[2][N][M];
        for (int i = 0; i<N; i++){
            String s = br.readLine();
            String sBits[] = s.split("");
            for (int j = 0; j<M; j++){
                wall[i][j] = Integer.parseInt(sBits[j]);
            }
        }
        int answer = bfs(0,0,0,1);
        System.out.println(answer);
    }
}
