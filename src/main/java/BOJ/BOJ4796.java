package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0){
                break;
            }
            int mod = V % P;
            int div = V / P;

            System.out.print("Case "+cnt+": ");
            if (mod < L){
                System.out.println(L * div + mod);
            } else {
                System.out.println(L * div + L);
            }

            cnt++;
        }

    }
}
