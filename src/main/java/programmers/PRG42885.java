package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRG42885 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> divList = new ArrayList<>();
        Arrays.sort(people);
        for (int i = 0; i<people.length; i++){
            list.add(people[i]);
        }
        int i = 0;
        int ride = 0;
        for (int j = list.size() - 1; j>=i; j--){
            if (i == j) {
                ride = 0;
                break;
            }
            ride = 0;
            if (list.get(i) + list.get(j) <= limit) {
                i++;
                answer++;
                ride = 1;
            } else {
                answer++;
            }
        }
        if (ride == 0) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{70,50,80,50},100);
//        solution(new int[]{70,80,50},100);
    }
}
