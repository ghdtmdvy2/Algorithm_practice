package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {
    static String[][] sol;
    static int visited[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static int BFS(String search, int sx, int sy){
        int cnt = 1;
        visited[sx][sy] = 1;
        sol[sx][sy] = "X";
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
        while(!queue.isEmpty()){
            int current[] = queue.remove();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i<4; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx > visited.length - 1 || vy > visited[0].length - 1) {
                    continue;
                }
                if (sol[vx][vy].equals(search) && visited[vx][vy] == 0){
                    visited[vx][vy] = 1;
                    sol[vx][vy] = "X";
                    cnt++;
                    queue.add(new int[]{vx,vy});
                }
            }
        }
        return cnt * cnt;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Bcnt = 0;
        int Wcnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sol = new String[M][N];
        visited = new int[M][N];
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String bits[] = st.nextToken().split("");
            for (int j = 0; j<N; j++){
                sol[i][j] = bits[j];
            }
        }
        for (int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                if (visited[i][j] == 0 && sol[i][j].equals("W")){
                    Wcnt = Wcnt + BFS(sol[i][j],i,j);
                }
                else if (visited[i][j] == 0 && sol[i][j].equals("B")){
                    Bcnt = Bcnt + BFS(sol[i][j],i,j);
                }
            }
        }
        bw.write(Wcnt +" " +Bcnt);
        bw.flush();
        bw.close();
    }
}
