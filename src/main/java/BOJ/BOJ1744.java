package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1744 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqPlus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>();
        int zeroCnt = 0;
        for (int i = 0; i<N; i++){
            int v = Integer.parseInt(br.readLine());
            if (v == 0) {
                zeroCnt++;
            } else if ( v < 0 ) {
                pqMinus.add(v);
            } else {
                pqPlus.add(v);
            }
        }
        int answer = 0;

        // 1. 양수가 1인 것은 곱해주는 것보다 더하기.
        // 2. 양수 1보다 큰 것은 곱해서 더 해주기.
        // 3. 0인 숫자는 음수 중 제일 작은 것과 곱해주기.
        while (pqPlus.size() >= 2) {
            int v1 = pqPlus.poll();
            int v2 = pqPlus.poll();
            if (v1 == 1 || v2 == 1) {
                answer += v1 + v2;
                break;
            } else {
                answer += v1 * v2;
            }
        }
        while (!pqPlus.isEmpty()) {
            answer += pqPlus.poll();
        }
        while (pqMinus.size() >= 2) {
            int v1 = pqMinus.poll();
            int v2 = pqMinus.poll();
            answer += v1 * v2;
        }
        while (!pqMinus.isEmpty()) {
            if (zeroCnt > 0) {
                zeroCnt--;
                pqMinus.poll();
            } else {
                answer += pqMinus.poll();
            }
        }
        System.out.println(answer);
    }
}
