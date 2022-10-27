package BOJ;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2693
class BOJ2693 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int[][] A = new int[T][10];
        for (int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<10; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A[i]);
            bw.write(A[i][7] + "\n");
        }
        bw.flush();
        bw.close();
    }
}