package programmers;

import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class PRG43162 {
    static int node[][];
    static int check[];
    public static void dfs(int start,int computers[][]){
        check[start] = 1;
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int c = queue.remove();
            for (int i = 0; i<computers[0].length; i++){
                if (computers[c][i] == 1 && check[i] != 1) {
                    check[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new int[n];
        for (int i = 0; i<n; i++){
            if (check[i] != 1) {
                answer++;
                dfs(i,computers);
            }
        }
        return answer;
    }
}
