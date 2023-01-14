package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Integer.parseInt(st.nextToken());
        long dest = Integer.parseInt(st.nextToken());
        long cnt = 0;
        boolean chk = false;
        while (dest > 0) {
            cnt++;
            if (dest == start) {
                chk = true;
                break;
            }
            if (dest > 10 && dest % 10 == 1){
                dest = dest / 10;
                continue;
            }
            if (dest % 2 == 1) {
                System.out.println(-1);
                return;
            }
            dest = dest / 2;
        }
        if (chk) {
            System.out.println(cnt);
            return;
        }
        System.out.println(-1);
    }
}
