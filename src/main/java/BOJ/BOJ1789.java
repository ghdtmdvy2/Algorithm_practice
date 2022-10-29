package BOJ;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1789
public class BOJ1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long max = 0;
        long sum = 0;
        long answer = 0;
        for (long i = 0; i<=N; i++) {
            sum = sum + i;
            if (sum == N) {
                answer = i;
                break;
            }
            if (sum > N) {
                answer = i - 1;
                break;
            }
        }
        System.out.println(answer);

    }
}
