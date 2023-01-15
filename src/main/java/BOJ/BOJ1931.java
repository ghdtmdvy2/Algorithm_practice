package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1931 {
    static int v[];
    static int ans = 0;
    public static boolean possible(int row) {
        for (int i = 1; i<row; i++){
            if (v[i] == v[row]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(v[i] - v[row])) {
                return false;
            }
        }
        return true;
    }
    public static void n_queen(int depth, int N){
        if (depth > N){
            ans++;
            return;
        }
        for (int i = 1; i<=N; i++){
            v[depth] = i;
            if (possible(depth)){
                n_queen(depth+1, N);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        v = new int[N+1];
        n_queen(1,N);
        System.out.println(ans);
    }
}
