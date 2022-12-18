package programmers;

public class PRG120821 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int answerIndex = 0;
        for(int i = num_list.length-1; i>=0; i--){
            answer[answerIndex] = num_list[i];
            answerIndex++;
        }
        return answer;
    }
}
