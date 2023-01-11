package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
    static class Value implements Comparable<Value>{
        int v;
        Value(int v) {
            this.v = v;
        }
        @Override
        public int compareTo(Value o) {
            if (this.v < o.v) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Value> pq = new PriorityQueue<>();
        for (int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            pq.add(new Value(x));
        }
        int ans = 0;
        while(!pq.isEmpty()) {
            Value value1 = pq.remove();
            if (!pq.isEmpty()) {
                Value value2 = pq.remove();
                int plus = value1.v + value2.v;
                ans = ans + value1.v + value2.v;
                if (pq.isEmpty()) {
                    break;
                } else {
                    pq.add(new Value(plus));
                }
            }
        }
        System.out.println(ans);
    }
}
