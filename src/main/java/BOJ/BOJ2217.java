package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 50,52
        // 51
        int sum = 0;
        Integer weights[] = new Integer[N];
        int maxWeights[] = new int[N];
        for(int i = 0; i<N; i++){
            weights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weights, Collections.reverseOrder());
        int maxWeight = weights[0];
        int j = 0;
        sum = maxWeight;
        for(int i = 0; i<N; i++){
            if (maxWeight <= sum/(i+1)){
                maxWeight = sum / (i+1);
                sum = 0;
            } else if (maxWeight <= weights[i] * (i+1)){
                maxWeight = weights[i] * (i+1);
                sum = 0;
            }
        }
        bw.write(String.valueOf(maxWeight));


        bw.flush();
        bw.close();
    }
}
