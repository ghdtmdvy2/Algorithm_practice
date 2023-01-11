package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    static class Value implements Comparable<Main.Value>{
        int v;
        Value(int v) {
            this.v = v;
        }
        @Override
        public int compareTo(Main.Value o) {
            if (Math.abs(this.v) == Math.abs(o.v)){
                if (this.v < o.v) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (Math.abs(this.v) > Math.abs(o.v)) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Main.Value> pq = new PriorityQueue<>();
        for (int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.remove().v);
                } else {
                    System.out.println(0);
                }
            } else {
                pq.add(new Main.Value(x));
            }
        }
    }
}
