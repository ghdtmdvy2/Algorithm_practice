package programmers;

import java.util.Arrays;
// https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=java
public class PGR12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int cnt = 0;
        for (int i = 0; i < d.length; i++){
            if (budget >= d[i]){
                budget -= d[i];
                cnt++;
            }
        }
        return cnt;
    }
}
