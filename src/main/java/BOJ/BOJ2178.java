package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[][] visited;
    static int[][] miro;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void BFS(){
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int current[] = queue.remove();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx > visited.length - 1 || vy > visited[0].length - 1){
                    continue;
                }
                if (visited[vx][vy] == 0 && miro[vx][vy] == 1) {
                    visited[vx][vy] = visited[cx][cy] + 1;
                    queue.add(new int[]{vx,vy});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        miro = new int[N][M];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] bits = st.nextToken().split("");
            for (int j = 0; j<M; j++){
                miro[i][j] = Integer.parseInt(bits[j]);
            }
        }
        BFS();
        System.out.println(visited[miro.length-1][miro[0].length-1]);
    }
}
