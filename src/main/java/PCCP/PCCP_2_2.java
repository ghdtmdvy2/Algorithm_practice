package PCCP;

import java.util.Arrays;

public class PCCP_2_2 {
    public int solution(int[] ability, int number) {
        int answer = 0;
        Arrays.sort(ability);
        for(int i = 0; i<number; i++){
            int sum = ability[0] + ability[1];
            ability[0] = sum;
            ability[1] = sum;
            if (sum > ability[2]){
                Arrays.sort(ability);
            }

        }
        for (int d : ability){
            answer = answer + d;
        }
        return answer;
    }
}
