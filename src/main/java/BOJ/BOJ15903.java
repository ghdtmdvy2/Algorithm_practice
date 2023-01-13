package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            priorityQueue.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i<M; i++){
            long v1 = priorityQueue.poll();
            long v2 = priorityQueue.poll();
            long sum = v1 + v2;
            priorityQueue.add(sum);
            priorityQueue.add(sum);
        }
        long ans = 0;
        while(!priorityQueue.isEmpty()){
            ans = ans + priorityQueue.poll();
        }
        System.out.println(ans);
    }
}
