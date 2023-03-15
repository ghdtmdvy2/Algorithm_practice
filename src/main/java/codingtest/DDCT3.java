package codingtest;

import java.util.Stack;

class DDCT3 {
    public static int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        // 해당 문자열을 문자로 추출하기 위한 split
        String[] sSplit = s.split("");
        for (String v : sSplit) {
            // stack 이 비어있을 경우 값을 그냥 stack 에 저장.
            if (stack.isEmpty()){
                stack.push(v);
            }
            // 알파벳 2개 붙어 있는 짝이 붙어 있는 경우 stack 에 있는 값을 없애줌
            else if (stack.peek().equals(v)) {
                stack.pop();
            }
            // 알파벳 2개 붙어 있는 짝이 아닌 경우 stack 에 값을 넣어줌.
            else {
                stack.push(v);
            }
        }

        int answer = 0;
        // 해당 stack 이 비어있는 경우 짝지어 제거하기가 모두 성공했음을 뜻함. 그래서 answer 에 1을 넣어줌.
        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}