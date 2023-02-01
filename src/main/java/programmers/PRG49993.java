package programmers;

import java.util.ArrayList;
import java.util.List;

public class PRG49993 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i<skill.length(); i++) {
            list.add(String.valueOf(skill.charAt(i)));
        }
        for (String skill_tree : skill_trees) {
            int chk = 0;
            int index = 0;
            for (int i = 0; i<skill_tree.length(); i++){
                if (index >= list.size()) {
                    break;
                }
                if (!(list.get(index).equals(String.valueOf(skill_tree.charAt(i)))) && list.contains(String.valueOf(skill_tree.charAt(i))) ) {
                    chk = 1;
                    break;
                }
                else if (list.size() > 0 && list.get(index).equals(String.valueOf(skill_tree.charAt(i)))){
                    index++;
                }
            }
            if (chk == 0) {
                answer++;
            }
        }
        return answer;
    }
}
