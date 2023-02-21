package programmers;

public class PRG12924 {
    public int solution(int n) {
        int value = n;
        int answer = 0;
        while (value > 0) {
            int finnValue = 0;
            for (int i = value; i>=1; i--){
                finnValue += i;
                if (finnValue == n) {
                    answer++;
                    break;
                }
                else if (finnValue > n) {
                    break;
                }
            }
            value--;
        }
        return answer;
    }
}
