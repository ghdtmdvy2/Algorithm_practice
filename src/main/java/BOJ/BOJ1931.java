package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1931 {
    static class Coference implements Comparable<Coference>{
        int start;
        int end;
        Coference(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Coference o){
            if (this.end == o.end) {
                if (this.start > o.start) {
                    return 1;
                } else {
                    return -1;
                }
            }
            else if (this.end < o.end){
                return -1;
            } else {
                return 1;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Coference> pq = new PriorityQueue<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Coference(start, end));
        }
        int ans = 0;
        int prev = 0;
        while(!pq.isEmpty()){
            Coference cf = pq.poll();
            if (cf.start >= prev) {
                ans++;
                prev = cf.end;
            }
        }
        System.out.println(ans);
    }
}
