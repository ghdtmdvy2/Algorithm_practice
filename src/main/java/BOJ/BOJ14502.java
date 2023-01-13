package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int science[][];
    static int visited[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int oWall = 0;
    static int ans = 0;
    static int vCnt = 0;
    public static void dfs(int sx, int sy, int cnt){
        visited[sx][sy] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy,cnt});
        while(!queue.isEmpty()){
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            int cCnt = c[2];
            for (int i = 0; i<4; i++){
                int vx = dx[i] + cx;
                int vy = dy[i] + cy;
                if (vx < 0 || vy < 0 || vx >= science.length || vy >= science[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && science[vx][vy] == 0) {
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cCnt+1});
                    vCnt++;
                }
            }
        }
    }
    public static void wallSet(int cnt){
        if (cnt == 3) {
            for (int i = 0; i< science.length; i++){
                for (int j = 0; j<science[0].length; j++){
                    if (science[i][j] == 2) {
                        vCnt++;
                        dfs(i,j,0);
                    }
                }
            }
            visited = new int[science.length][science[0].length];
            int safeArea = science.length * science[0].length - (vCnt + oWall + 3);
            ans = Math.max(safeArea,ans);
            vCnt = 0;
            return;
        }
        for (int i = 0; i< science.length; i++){
            for (int j = 0; j<science[0].length; j++){
                if (science[i][j] == 0){
                    science[i][j] = 1;
                    wallSet(cnt + 1);
                    science[i][j] = 0;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        science = new int[L][W];
        visited = new int[L][W];
        for (int i = 0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<W; j++){
                int v = Integer.parseInt(st.nextToken());
                science[i][j] = v;
                if (v == 1) {
                    oWall++;
                }
            }
        }
        wallSet(0);
        System.out.println(ans);
    }
}
