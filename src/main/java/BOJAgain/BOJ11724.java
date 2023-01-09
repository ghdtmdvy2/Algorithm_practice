package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int node[][];
    static int check[];
    public static void bfs(int start){
        check[start] = 1;
        for (int i = 1; i<node.length; i++){
            if (node[start][i] == 1 && check[i] == 0) {
                bfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        node = new int[N+1][N+1];
        check = new int[N+1];
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = 1;
            node[y][x] = 1;
        }
        int answer = 0;
        for(int i = 1; i<check.length; i++){
            if (check[i] == 0) {
                answer++;
                bfs(i);
            }
        }
        System.out.println(answer);
    }
}
