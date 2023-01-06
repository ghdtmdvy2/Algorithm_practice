package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1260_2 {
    static int node[][];
    static int check[][];
    public static void dfsBfs(int startX) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        Stack<Integer> stack = new Stack<>();
        stack.add(startX);

        while(!stack.isEmpty()) {
            int c = stack.pop();
            if (check[1][c] == 0) {
                System.out.print(c + " ");
            }
            check[1][c] = 1;
            for (int i = node.length - 1; i>=1; i--){
                if(check[1][i] == 0 && node[c][i] == 1) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
        while(!queue.isEmpty()) {
            int c = queue.remove();
            if (check[0][c] == 0) {
                System.out.print(c + " ");
            }
            check[0][c] = 1;
            for (int i = 1; i< node.length; i++){
                if(check[0][i] == 0 && node[c][i] == 1) {
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        node = new int[N+1][N+1];
        check = new int[2][N+1];
        for (int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = 1;
            node[y][x] = 1;
        }
        dfsBfs(V);
    }
}
