package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N==1){
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        long lineLength[] = new long[N-1];
        long line[] = new long[N];
        long sortLine[] = new long[N-1];
        for (int i = 0; i<N-1; i++){
            lineLength[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            line[i] = Long.parseLong(st.nextToken());
            if (i == N-1){
                continue;
            } else {
                sortLine[i] = line[i];
            }
        }
        Arrays.sort(sortLine);
        int check = 0;
        long sum = 0;
        long min = line[0];
        for(int i = 0; i<N-1; i++){
            if (min > line[i]){
                min = line[i];
            }
            sum = sum + (lineLength[i]*min);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
