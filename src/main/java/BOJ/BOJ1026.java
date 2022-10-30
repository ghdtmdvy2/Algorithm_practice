package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer A[] = new Integer[N];
        Integer B[] = new Integer[N];
        for (int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i<N; i++){
            sum = sum + (A[i]*B[i]);
        }
        System.out.println(sum);
    }
}
