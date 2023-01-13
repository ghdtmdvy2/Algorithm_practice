package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2847 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] level = new int[N];
        for (int i = 0; i<N; i++){
            level[i] = Integer.parseInt(br.readLine());
        }
        int i = 0;
        int sum = 0;
        while(i+1 < N){
            if (level[i] >= level[i+1]){
                int minus = level[i];
                level[i] = level[i+1] - 1;
                sum += minus - level[i];
                i = 0;
                continue;
            }
            i++;
        }
        System.out.println(sum);
    }
}
