package programmers;
import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class PRG12906 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<arr.length;i++){
            if (stack.size() == 0 ){
                stack.push(arr[i]);
                continue;
            }
            if (stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }
        int stackSize = stack.size();
        int[] answer = new int[stackSize];
        for (int i = stackSize - 1; i>= 0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}
