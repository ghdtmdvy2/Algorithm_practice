package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14916 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n > 0) {
            if (n % 5 == 0) {
                cnt = cnt + n / 5;
                n = n / 5;
                break;
            }
            n = n - 2;
            cnt++;
        }
        if (n < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(cnt);
    }
}
