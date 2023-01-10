package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 {
    static String path[][];
    static int visited[][];
    static Queue<int[]> queue = new LinkedList<>();
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static int bfs(){
        while(!queue.isEmpty()) {
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            int cCnt = c[2];
            int obj = c[3];
            if (path[cx][cy].equals("D")){
                return cCnt;
            }
            for (int i = 0; i<4; i++){
                int vx = dx[i] + cx;
                int vy = dy[i] + cy;
                if (vx < 0 || vy < 0 || vx >= path.length || vy >= path[0].length) {
                    continue;
                }
                if (path[cx][cy].equals("*") && visited[vx][vy] == 0 && !path[vx][vy].equals("X") && !path[vx][vy].equals("D") && !path[vx][vy].equals("S")) {
                    path[vx][vy] = "*";
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy,0,1});
                }
                if (path[cx][cy].equals("S") && visited[vx][vy] == 0 && !path[vx][vy].equals("X") && !path[vx][vy].equals("*")) {
                    if(!path[vx][vy].equals("D")) {
                        path[vx][vy] = "S";
                    }
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cCnt + 1,2});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        path = new String[R][C];
        visited = new int[R][C];
        for (int i = 0; i<R; i++){
            String s[] = br.readLine().split("");
            for (int j = 0; j<C; j++){
                path[i][j] = s[j];
            }
        }
        int chk = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i<R; i++){
            for (int j = 0; j<C; j++){
                if (path[i][j].equals("S") && chk == 0){
                    x = i;
                    y = j;
                    chk = 1;
                }
                if (path[i][j].equals("*")) {
                    queue.add(new int[]{i,j,0,1});
                }
            }
        }
        if (chk == 1) {
            queue.add(new int[]{x,y,0,2});
        }
        int answer = bfs();
        if (answer == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(answer);
    }
}
