package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2217 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer weight[] = new Integer[N];
        for (int i = 0; i<N; i++){
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight, Collections.reverseOrder());
        int max = weight[0];
        for (int i = 1; i<=N; i++){
            max = Math.max(weight[i-1]*i,max);
        }
        System.out.println(max);
    }
}
