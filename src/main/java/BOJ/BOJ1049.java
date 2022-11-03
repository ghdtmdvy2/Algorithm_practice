package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1049 {
    static double guitarPackage[];
    static double guitarOne[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double value = 0;
        guitarPackage = new double[M];
        guitarOne = new double[M];
        double packageMoney = 0, oneMoney = 0,packageOneMoney = 0;
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            packageMoney = Integer.parseInt(st.nextToken());
            oneMoney = Integer.parseInt(st.nextToken());
            guitarOne[i] = oneMoney;
            guitarPackage[i] = packageMoney;


        }
        Arrays.sort(guitarOne);
        double minOne = guitarOne[0];
        Arrays.sort(guitarPackage);
        double minPackage = guitarPackage[0];
        while (N > 0){
            if (N - 6 > 0){
                N = N - 6;
                if (minPackage < minOne * 6){
                    value = value + minPackage;
                } else {
                    value = value + minOne * 6;
                }
            } else {
                if (minPackage > minOne * N){
                    value = value + minOne * N;
                } else {
                    value = value + minPackage;
                }
                break;
            }

        }
        bw.write(String.valueOf((int) value));
        bw.flush();
        bw.close();
    }
}
