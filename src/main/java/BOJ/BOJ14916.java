package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14916 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        while(N > 0) {
            if (N % 5 == 0) {
                sum = sum + N / 5;
                break;
            }
            N = N - 2;
            sum++;
        }
        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
        }
    }
}
