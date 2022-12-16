package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1743 {
    static int[][] sol;
    static int[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static int bfs(int sx,int sy){
        visited[sx][sy] = 1;
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
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
                if (sol[vx][vy] == 1 && visited[vx][vy] == 0){
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy});
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sol = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sol[r-1][c-1] = 1;
        }
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (visited[i][j] == 0 && sol[i][j] != 0) {
                    int trashcnt = bfs(i,j);
                    if (answer < trashcnt){
                        answer = trashcnt;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
