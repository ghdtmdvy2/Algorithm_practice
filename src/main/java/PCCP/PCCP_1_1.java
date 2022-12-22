package PCCP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PCCP_1_1 {
    class Solution {
        public String solution(String input_string) {
            String[] bits = input_string.split("");
            List<String> list = new ArrayList<>();
            for (String bit : bits){
                if (list.size() == 0) {
                    list.add(bit);
                } else {
                    int size = list.size() - 1;
                    if(!(list.get(size).equals(bit))){
                        list.add(bit);
                    } else {
                        continue;
                    }
                }
            }
            String answer = "";
            List<String> answerList = new ArrayList<>();
            int index = 0;
            for (int i = 0; i<list.size(); i++){
                String find = list.get(i);
                int cnt = 0;
                for (int j = i+1; j<list.size(); j++){
                    if (find.equals("X")){
                        break;
                    }
                    if (find.equals(list.get(j))) {
                        if (cnt == 0){
                            answerList.add(list.get(j));
                        }
                        cnt = 1;

                        list.set(j,"X");
                    }
                }
            }
            Collections.sort(answerList);
            for (int i = 0; i<answerList.size(); i++){
                answer = answer + answerList.get(i);
            }
            if (answerList.size() == 0){
                answer = "N";
            }
            return answer;
        }
    }
}
