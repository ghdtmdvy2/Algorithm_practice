package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<=N; i++){
            line[i] = 0;
        }
        int sum = 0;
        for(int i = 1; i<=N; i++){
            line[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(line);
        for (int i = 1; i<=N; i++){
            line[i] = line[i-1] + line[i];
            sum = sum + line[i];
        }
        System.out.println(sum);
    }
}
