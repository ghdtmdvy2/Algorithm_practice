package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PRG12941 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> pqSmall = new PriorityQueue<>();
        PriorityQueue<Integer> pqBig = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : A){
            pqSmall.add(a);
        }
        for (int b : B){
            pqBig.add(b);
        }
        while (!(pqSmall.isEmpty()) && !(pqBig.isEmpty())){
            Integer big = pqBig.poll();
            Integer small = pqSmall.poll();
            answer += big * small;
        }

        return answer;
    }
}
