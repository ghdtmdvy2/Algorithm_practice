package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    static int visited[][];
    static int chess[][];
    static int dx[] = {-1,-2,-2,-1,1,2,2,1};
    static int dy[] = {2,1,-1,-2,-2,-1,1,2};
    public static void bfs(int sx, int sy){
        visited[sx][sy] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i<dx.length; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= visited.length || vy >= visited.length) {
                    continue;
                }
                if (visited[vx][vy] == 0) {
                    visited[vx][vy] = 1;
                    chess[vx][vy] = chess[cx][cy] + 1;
                    queue.add(new int[]{vx,vy});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i<tc; i++){
            int size = Integer.parseInt(br.readLine());
            visited = new int[size][size];
            chess = new int[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            bfs(sx,sy);
            System.out.println(chess[ax][ay]);
        }
    }
}
