package programmers;

import java.util.Stack;

public class PRG12973 {
    public static int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        if (stack.isEmpty() && i > 0) {
            answer = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}
