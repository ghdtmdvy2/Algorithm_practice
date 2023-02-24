package programmers;

public class PRG42842 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int area = brown + yellow;
        for (int i = 3; i<=area; i++){
            if (area % i == 0){
                // 가로 길이
                answer[0] = i;
                // 세로 길이
                answer[1] = area / i;
                int outside = answer[0] * 2 + (answer[1] - 2) * 2;
                int middle = area - outside;
                if (middle == yellow) {
                    break;
                }
            }
        }
        if (answer[0] < answer[1]) {
            int swap = answer[1];
            answer[1] = answer[0];
            answer[0] = swap;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(8,1);
    }
}
