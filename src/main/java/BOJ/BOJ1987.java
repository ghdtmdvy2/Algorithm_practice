package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1987 {
    static String node[][];
    static int check[];
    static int ans = 0;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void dfs(int startX,int startY ,int cnt) {
        ans = Math.max(ans,cnt);
        String v = node[startX][startY];
        check[Integer.valueOf("Z".charAt(0) - v.charAt(0))] = 1;
        for (int i = 0; i<4; i++){
            int vx = startX + dx[i];
            int vy = startY + dy[i];
            if (vx < 0 || vy < 0 || vx >= node.length || vy >= node[0].length) {
                continue;
            }
            int s = Integer.valueOf("Z".charAt(0) - node[vx][vy].charAt(0));
            if (check[s] == 0) {
                check[s] = 1;
                dfs(vx,vy,cnt + 1);
                check[s] = 0;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        node = new String[N][M];
        int size = "Z".charAt(0) - "A".charAt(0);
        check = new int[size + 1];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j<M; j++){
                node[i][j] = s[j];
            }
        }
        dfs(0,0,1);
        System.out.println(ans);
    }
}
