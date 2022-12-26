package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026 {
    static String color[][];
    static int visited_1[][];
    static int visited_2[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void bfs(int noColor, int searchX, int searchY, String searchColor){
        if (noColor == 1) {
            visited_1[searchX][searchY] = 1;
        } else {
            visited_2[searchX][searchY] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{searchX,searchY});
        while(!queue.isEmpty()){
            int current[] = queue.remove();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i<dx.length; i++){
                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= color.length || vy >= color[0].length){
                    continue;
                }
                if (noColor == 0 && visited_2[vx][vy] == 0 && color[vx][vy].equals(searchColor)){
                    visited_2[vx][vy] = 1;
                    queue.add(new int[]{vx,vy});
                }
                if (noColor == 1 && visited_1[vx][vy] == 0 && (searchColor == "G" && (color[vx][vy].equals("G") || color[vx][vy].equals("R")))){
                    visited_1[vx][vy] = 1;
                    queue.add(new int[]{vx,vy});
                } else if (noColor == 1 && visited_1[vx][vy] == 0 && color[vx][vy].equals(searchColor)) {
                    visited_1[vx][vy] = 1;
                    queue.add(new int[]{vx,vy});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        color = new String[N][N];
        visited_1 = new int[N][N];
        visited_2 = new int[N][N];
        int cnt_1 = 0;
        int cnt_2 = 0;
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String bits[] = st.nextToken().split("");
            for (int j = 0; j<bits.length; j++){
                color[i][j] = bits[j];
            }
        }
        for (int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if (visited_2[i][j] == 0 && color[i][j].equals("R")) {
                    bfs(0,i,j,"R");
                    cnt_1++;
                } else if (visited_2[i][j] == 0 && color[i][j].equals("B")) {
                    bfs(0,i,j,"B");
                    cnt_1++;
                }else if (visited_2[i][j] == 0 && color[i][j].equals("G")) {
                    bfs(0,i,j,"G");
                    cnt_1++;
                }
            }
        }
        for (int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if (visited_1[i][j] == 0 && color[i][j].equals("B")) {
                    bfs(1,i,j,"B");
                    cnt_2++;
                } else if (visited_1[i][j] == 0 && (color[i][j].equals("G") || color[i][j].equals("R"))) {
                    bfs(1,i,j,"G");
                    cnt_2++;
                }
            }
        }
        System.out.print(cnt_1+" ");
        System.out.print(cnt_2);
    }
}
