package programmers;

import java.util.ArrayList;
import java.util.List;

public class PGR12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        // 첫번째 단어.
        String word = words[0];
        List<String> list = new ArrayList<>();
        list.add(word);
        int num = 1;
        int turn = 1;
        boolean chk = false;
        for (int i = 1; i<words.length; i++){
            num++;
            if (num - n == 1) {
                turn++;
                num = 1;
            }
            if (!(word.charAt(word.length() - 1) == words[i].charAt(0))
                    || list.contains(words[i])) {
                chk = true;
                break;
            }
            list.add(words[i]);
            word = words[i];
        }
        if (chk) {
            answer[0] = num;
            answer[1] = turn;
        }

        return answer;
    }
}
