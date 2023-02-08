package programmers;

import java.util.Arrays;

public class PRG12987 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        // 1 : 1
        // 2 : 2 3
        // 3 : 4
        int j = 0;
        for (int i = 0; i<A.length; i++){
            while (j < B.length) {
                if (A[i] < B[j]) {
                    j++;
                    answer++;
                    break;
                }
                j++;
            }
        }
        return answer;
    }
}
