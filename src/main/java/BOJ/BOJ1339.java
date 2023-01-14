package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1339 {
    static class Alpha implements Comparable<Alpha>{
        long v;
        String vAlpha;
        Alpha(long v, String vAlpha) {
            this.v = v;
            this.vAlpha = vAlpha;
        }
        public int compareTo(Alpha o){
            if (this.v < o.v){
                return 1;
            } else {
                return -1;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long alphaCnt[] = new long["Z".charAt(0) - "A".charAt(0) + 1];
        long alphaValue[] = new long["Z".charAt(0) - "A".charAt(0) + 1];
        PriorityQueue<Alpha> pq = new PriorityQueue<>();
        String alpha[][] = new String[N][10];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            String s[] = br.readLine().split("");
            int size = s.length;
            list.add(size);
            for (int j = 0; j<s.length; j++){
                alpha[i][j] = s[j];
                alphaCnt[s[j].charAt(0) - "A".charAt(0)] += (long)Math.pow(10, size - 1);
                size--;
            }
        }
        for (int i = 0; i<alphaCnt.length; i++){
            if (alphaCnt[i] != 0) {
                char c = (char)("A".charAt(0) + i);
                pq.add(new Alpha(alphaCnt[i],String.valueOf(c)));
            }
        }
        int setValue = 9;
        while (!pq.isEmpty()) {
            Alpha alphabet = pq.remove();
            int size = alphabet.vAlpha.charAt(0) - "A".charAt(0);
            alphaValue[size] = setValue;
            setValue--;
        }
        int ans = 0;
        for (int i = 0; i<N; i++){
            int listSize = list.remove(0);
            int M = listSize;
            for (int j = 0; j<M; j++){
                String a = alpha[i][j];
                ans += alphaValue[a.charAt(0) - "A".charAt(0)] * Math.pow(10,listSize-1);
                listSize--;
            }
        }
        System.out.println(ans);
    }
}
