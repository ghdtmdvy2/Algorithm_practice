package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1978
class BOJ1978 {
    public static int findDecimal(int number){
        int cnt = 0;
        for (int i = 1; i<=number; i++){
            if (number % i == 0 ) {
                cnt++;
            }
        }
        if (cnt == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i = 0; i<N; i++){
            answer = answer + findDecimal(Integer.parseInt(st.nextToken()));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}