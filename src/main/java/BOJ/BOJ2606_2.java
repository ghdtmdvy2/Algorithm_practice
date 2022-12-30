package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_2 {
    static int[] check;
    static int[][] node;
    public static void dfs(int start){
        check[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int cnt = 0;
        while(!queue.isEmpty()) {
            int c = queue.remove();
            for (int i = 1; i<node.length; i++){
                if (node[c][i] == 1 && !(check[i] == 1)) {
                    check[i] = 1;
                    cnt++;
                    queue.add(i);
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        node = new int[N+1][N+1];
        check = new int[N+1];
        for (int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = 1;
            node[y][x] = 1;
        }
        dfs(1);
    }
}
