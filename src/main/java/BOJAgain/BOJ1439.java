package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1439 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String sBit[] =  s.split("");
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(sBit[0]));
        for (String v : sBit) {
            if (stack.peek() != Integer.parseInt(v)){
                stack.push(Integer.parseInt(v));
            }
        }
        int zero = 0;
        int one = 0;
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if (pop == 0) {
                zero++;
            } else {
                one++;
            }
        }
        System.out.println(Math.min(zero,one));
    }
}
