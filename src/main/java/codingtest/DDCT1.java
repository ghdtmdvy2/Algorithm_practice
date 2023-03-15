package codingtest;

import java.util.*;

public class DDCT1 {
    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int v : arr) {
            // stack 의 들어있는 값이 하나도 없을 때 비교 할 값이 없으므로 push 하고 넘어가기.
            if (stack.isEmpty()) {
                stack.push(v);
                list.add(v);
            }
            // stack 의 들어있는 값이 만약에 이미 들어간 숫자가 아닌 경우( 연속적으로 나타나는 숫자가 아닐 경우 )
            else if (stack.peek() != v) {
                stack.push(v);
                list.add(v);
            }
            // stack 의 들어있는 값이 만약에 이미 들어간 숫자가 맞는 경우( 연속적으로 나타나는 숫자인 경우 )
            else {
                continue;
            }
        }
        // 해당 저장된 list 값을 정적 배열에 다시 저장해주는 로직.
        int answer[] = new int[list.size()];
        for (int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1,1,3,3,0,1,1});
    }
}