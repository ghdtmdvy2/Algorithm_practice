package codingtest;

import java.util.Queue;

public class GOCT3 {
    public static int solution(int[] estimates, int k) {
        int max = 0;
        int v = 0;
        int cnt = 0;
        int minusCnt = 0;
        for (int i = 0; i < estimates.length; i++){
            if (cnt == k) {
                int value = v - estimates[minusCnt] + estimates[i];
                max = Math.max(value,max);
                v = value;
                minusCnt++;
            } else {
                v += estimates[i];
                max = v;
                cnt++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        solution(new int[]{5,1,9,8,10,5}, 3);
        solution(new int[]{10,1,10,1,1,4,3,10}, 6);
    }
}
