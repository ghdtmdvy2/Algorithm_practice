package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PRG12939 {
    public String solution(String s) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        String sBit[] = s.split(" ");
        for (String sb : sBit){
            pqMax.add(Integer.parseInt(sb));
            pqMin.add(Integer.parseInt(sb));
        }
        int min = pqMin.poll();
        int max = pqMax.poll();
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}
