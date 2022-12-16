package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int A = 300;
        int B = 60;
        int C = 10;
        int Acnt = 0;
        int Bcnt = 0;
        int Ccnt = 0;
        if (T % 10 > 0){
            System.out.println(-1);
            return;
        }
        if (T >= A){
            Acnt = Acnt + (T/A);
            T = T % A;

        }
        if (T >= B){
            Bcnt = Bcnt + (T/B);
            T = T % B;

        }
        if (T >= C){
            Ccnt = Ccnt + (T/C);
            T = T % C;

        }
        System.out.print(Acnt);
        System.out.print(" "+Bcnt);
        System.out.print(" "+Ccnt);
    }
}
