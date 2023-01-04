package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2583 {
    static int square[][];
    static int visited[][];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static List<Integer> list = new ArrayList<>();
    public static void dfs(int x,int y){
        square[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int cnt = 1;
        while(!queue.isEmpty()){
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= square.length || vy >= square[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && square[vx][vy] == 0) {
                    cnt++;
                    visited[vx][vy] = 1;
                    square[vx][vy] = 1;
                    queue.add(new int []{vx,vy});
                }
            }
        }
        list.add(cnt);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        square = new int[M][N];
        visited = new int[M][N];
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            for (int j = x1; j<=x2; j++){
                for (int k = y1; k<=y2; k++){
                    square[j][k] = 1;
                }
            }

        }
        int answer = 0;
        for (int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                if (square[i][j] == 0) {
                    answer++;
                    dfs(i,j);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        for (int i = 0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
