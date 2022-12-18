package programmers;

import java.util.Arrays;

public class PRG42748 {
    public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];

        for (int i = 0; i<commands.length; i++){
            int index = 0;
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            int list[] = new int[b-a+1];
            for (int j = a-1; j<b; j++){
                list[index] = array[j];
                index++;
            }
            Arrays.sort(list);
            answer[i] = list[c-1];

        }

        return answer;
    }
}
