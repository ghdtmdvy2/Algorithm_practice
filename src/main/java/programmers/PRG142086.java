package programmers;
// https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class PRG142086 {
    public int[] solution(String s) {

        String[] bits = s.split("");
        int[] answer = new int[bits.length];
        int cnt = 0;
        for (int i = 0; i<bits.length; i++){
            String find = bits[i];
            int findIndex = i;
            answer[findIndex] = -1;
            for (int j = i-1; j>=0; j--){
                cnt++;
                if (bits[j].equals(find)){
                    answer[findIndex] = cnt;
                    break;
                }
            }
            cnt = 0;
        }
        return answer;
    }
}
