package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int tape = L;
        int location[] = new int[N];
        for (int i = 0; i<N; i++) {;
            location[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(location);
        int answer = 1;
        for (int i = 1; i<N; i++){
            int diff = Math.abs(location[i] - location[i - 1]);
            if (tape - diff > 0) {
                tape = tape - diff;
            } else {
                tape = L;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
