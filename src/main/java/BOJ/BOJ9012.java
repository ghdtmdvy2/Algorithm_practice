package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String[] bits = s.split("");
            int cnt = 0;
            Stack<String> stack = new Stack<>();
            for (String bit : bits){
                if (bit.equals("(")){
                    stack.push("(");
                } else if (stack.size() == 0){
                    System.out.println("NO");
                    cnt = 1;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.size() != 0) {
                System.out.println("NO");
            }else if (cnt != 1){
                System.out.println("YES");
            }
        }
    }
}
