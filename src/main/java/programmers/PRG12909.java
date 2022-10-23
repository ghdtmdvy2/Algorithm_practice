package programmers;

import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

class PRG12909 {
    // 1. Stack 이라는 String 형태로 만들어준다.
    Stack<String> stack = new Stack<>();

    boolean solution(String s) {
        boolean answer = true;
        String bracket;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.


        // 3. Stack 은 닫히는 괄호가 나오는 경우에는 pop을 해주고, 열리는 괄호가 나올 때 까지 pop을 해준다.
        // 3-1. 만약에 닫히는 괄호가 나온 후 열리는 괄호가 안나오면 false를 해주게 한다.
        // stack 초기값 세팅
        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (stack.size() == 0) {
                    answer = false;
                    break;
                }
                bracket = stack.pop();
                if (bracket.equals("(") ) {
                    continue;
                } else {
                    answer = false;
                }
            }
        }

        if (stack.size() > 0){
            answer = false;
        }
        return answer;
    }
}
