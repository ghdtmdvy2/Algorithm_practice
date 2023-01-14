package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long path[] = new long[N-1];
        long price[] = new long[N];
        long min = Long.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N-1; i++){
            path[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            price[i] = Long.parseLong(st.nextToken());
        }
        long prev = price[0];
        long answer = prev * path[0];
        for (int i = 1; i<N-1; i++){
            prev = Math.min(prev,price[i]);
            answer += prev * path[i];
        }
        System.out.println(answer);
    }
}
