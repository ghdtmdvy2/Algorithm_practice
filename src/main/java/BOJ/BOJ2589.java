package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    static String reward[][];
    static int visited[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int max = Integer.MIN_VALUE;
    public static void bfs(int sx, int sy){
        visited[sx][sy] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy,0});
        while(!queue.isEmpty()){
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            int cCnt = c[2];
            max = Math.max(max,cCnt);
            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= reward.length || vy >= reward[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && reward[vx][vy].equals("L")) {
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cCnt + 1});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        reward = new String[L][W];
        visited = new int[L][W];
        for (int i = 0; i<L; i++){
            String s[] = br.readLine().split("");
            for (int j = 0; j<W; j++){
                reward[i][j] = s[j];
            }
        }
        for (int i = 0; i<L; i++){
            for (int j = 0; j<W; j++){
                if (visited[i][j] == 0 && reward[i][j].equals("L")){
                    bfs(i,j);
                }
                visited = new int[L][W];
            }
        }
        System.out.println(max);
    }
}
