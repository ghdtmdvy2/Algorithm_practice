package PCCP;

import java.io.IOException;
import java.util.Stack;

public class PCCP_1_3 {
    static String[][] bio ={{"Rr"},{"RR","Rr","Rr","rr"}};
    public static String dfs(int sx, int sy){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sx,sy});
        while(sx > 2) {
            int by = sy / 4;
            int mod = sy % 4;
            sx = sx - 1;
            if (mod > 0) {
                by++;
            }
            sy = by;
            stack.push(new int[]{sx,by});
        }
        int[] current = stack.pop();
        int pcx = current[0];
        int pcy = current[1];
        String pBio = bio[pcx-1][pcy-1];
        String answer = null;
        while(!stack.isEmpty()) {
            int[] pop = stack.pop();
            int px = pop[0];
            int py = pop[1];
            if (pBio.equals("Rr")) {
                pcx = px;
                pcy = py;
                if (py % 4 == 0) {
                    pBio = "rr";
                } else if (py % 4 == 1) {
                    pBio = "RR";
                } else {
                    pBio = "Rr";
                }
            } else if (pBio.equals("RR")) {
                pBio = "RR";
            } else {
                pBio = "rr";
            }
        }
        return pBio;
    }
    public String[] solution(int[][] queries) throws IOException {
        String answer[] = new String[queries.length];
        for(int i = 0; i<queries.length; i++){
            answer[i] = dfs(queries[i][0],queries[i][1]);
        }
        return answer;
    }
}
