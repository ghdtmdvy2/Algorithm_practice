package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int value[];
    static int cal[];
    static String calString[] = {"+","-","*","/"};
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    public static void calculate(long d, int cnt){
        if (cnt == value.length - 1) {
            max = Math.max(d,max);
            min = Math.min(d,min);
            return;
        }
        for (int i = 0; i<4; i++){
            if (cal[i] == 0) {
                continue;
            }
            cal[i]--;
            long sum = 0;
            if (i == 0) {
                sum = d + value[cnt + 1];
            } else if (i == 1) {
                sum = d - value[cnt + 1];
            } else if (i == 2) {
                sum = d * value[cnt + 1];
            } else {
                if (d > 0) {
                    sum = d / value[cnt + 1];
                } else {
                    sum = (Math.abs(d) / value[cnt + 1]) * (-1);
                }
            }
            calculate(sum,cnt + 1);
            cal[i]++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        value = new int[N];
        cal = new int[4];
        for (int i = 0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }
        calculate(value[0], 0);
        System.out.println(max);
        System.out.println(min);
    }
}
