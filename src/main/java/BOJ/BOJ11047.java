package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static int coinGreedy(Integer coin,int[] coins, Integer N){
        int index = coins.length - 1;
        int cnt = 0;
        for (int j = index; j>=1; j--){
            cnt = cnt + coin / coins[j];
            coin = coin % coins[j];
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int coin = Integer.parseInt(st.nextToken());
        int coins[] = new int[N+1];
        for (int i = 1; i<=N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        bw.write(String.valueOf(coinGreedy(coin,coins,N)));
        bw.flush();
        bw.close();
    }
}
