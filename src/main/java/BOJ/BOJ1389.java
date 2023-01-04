package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 {
    static int[][] cabin;
    static int[] check;
    static int ans = Integer.MAX_VALUE;
    public static void bfs(int start,int dest,int cnt){
        check[start] = 1;
        for (int i = 1; i< cabin.length; i++){
            if (check[i] == 0 && cabin[start][i] == 1) {
                if (dest == start || i == dest) {
                    if (ans > cnt + 1) {
                        ans = cnt + 1;
                    }
                    return;
                }
                bfs(i,dest,cnt+1);
                check[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cabin = new int[N+1][N+1];
        check = new int[N+1];
        int[]answer = new int[N+1];
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            cabin[f1][f2] = 1;
            cabin[f2][f1] = 1;
        }
        for (int i = 1; i<=N; i++){
            for (int j = 1; j<=N; j++){
                check = new int[N+1];
                if (i == j) {
                    continue;
                }
                bfs(i,j, 0);
                answer[i] = answer[i] + ans;
                ans = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i<answer.length; i++){
            if (min >= answer[i]) {
                min = answer[i];
            }
        }
        for (int i = 1; i<answer.length; i++){
            if (min == answer[i]) {
                System.out.println(i);
                return;
            }
        }

    }
}
