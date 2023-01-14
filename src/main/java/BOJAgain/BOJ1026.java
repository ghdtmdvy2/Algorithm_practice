package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                if (i == 0) {
                    pq1.add(Integer.parseInt(st.nextToken()));
                } else {
                    pq2.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        int ans = 0;
        while(!pq1.isEmpty()){
            int a = pq1.poll();
            int b = pq2.poll();
            ans += a * b;
        }
        System.out.println(ans);
    }
}
