package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        stack.push(s[0]);
        int answer = 0;
        int bridge = 0;
        for (int i = 1; i< s.length; i++) {
            String c = stack.peek();
            if (c.equals("(")){
                // 막대기 추가
                if (s[i].equals("(")){
                    bridge = bridge + 1;
                    answer = answer + 1;
                }
                // 레이저 발사
                else {
                    answer = answer + bridge;
                }
            }
            // 막대기 길이 고정
            else {
                if (s[i].equals(")")){
                    bridge--;
                }
            }
            stack.push(s[i]);
        }
        System.out.println(answer);
    }
}
