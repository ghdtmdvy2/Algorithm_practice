package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class PRG86051 {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i = 0; i<numbers.length; i++){
            answer += numbers[i];
        }
        answer = 45 - answer;
        return answer;
    }
}
