package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234 {
    static int people[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int visited[][];

    static int ans = 0;
    class Area{
        int indexX;
        int indexY;
        int value;
        Area (int indexX, int indexY, int value){
            this.indexX = indexX;
            this.indexY = indexY;
            this.value = value;
        }
    }
    public int bfs(int sx, int sy, int L, int R) {
        visited[sx][sy] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
        List<Area> list = new ArrayList<>();
        list.add(new Area(sx,sy,people[sx][sy]));
        int sum = people[sx][sy];
        while(!queue.isEmpty()) {
            int c[] = queue.remove();
            int cx = c[0];
            int cy = c[1];
            for (int k = 0; k<4; k++) {
                int vx = cx + dx[k];
                int vy = cy + dy[k];
                if (vx < 0 || vy < 0 || vx >= people.length || vy >= people[0].length) {
                    continue;
                }
                if (visited[vx][vy] == 0 && Math.abs(people[cx][cy] - people[vx][vy]) <= R && Math.abs(people[cx][cy] - people[vx][vy]) >= L) {
                    visited[vx][vy] = 1;
                    queue.add(new int[]{vx,vy});
                    list.add(new Area(vx,vy,people[vx][vy]));
                    sum = sum + people[vx][vy];
                }
            }
        }
        if (list.size() > 1) {

            int avg = sum / list.size();
            for (int i = 0; i<list.size(); i++) {
                Area a = list.get(i);
                people[a.indexX][a.indexY] = avg;
            }
            return 1;
        }
        return 0;
    }
    public static void BOJ16234(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        people = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BOJ16234 m = new BOJ16234();
        int i = 0;
        int change = 0;
        while(true) {
            for (int j = 0; j<N; j++){
                if (visited[i][j] == 0) {
                    change = change + m.bfs(i,j,L,R);
                }
            }
            i++;
            if (i == N && change < 1) {
                break;
            } else if (i == N && change >= 1) {
                ans++;
                visited = new int[N][N];
                change = 0;
                i = 0;
            }
        }
        System.out.println(ans);
    }
}
