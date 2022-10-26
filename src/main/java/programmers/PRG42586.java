package programmers;

import java.util.ArrayList;
import java.util.List;
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class PRG42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 작업의 진도가 적힌 정수 배열 progresses
        // 각 작업의 개발 속도가 적힌 정수 배열 speeds
        int day = 0;
        List<Integer> days = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i<progresses.length; i++){
            while(progresses[i] < 100){
                int speed = speeds[i];
                progresses[i] += speed;
                day++;
            }
            days.add(day);
            day = 0;
        }
        // [5,10,1,1,20,1]
        // [1,3,2]

        // [7, 3, 9]
        // [1,]
        int maxDay = days.get(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<days.size(); i++){
            if (maxDay < days.get(i)){
                list.add(cnt);
                maxDay = days.get(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        int answer[] = new int[list.size()];
        for (int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
