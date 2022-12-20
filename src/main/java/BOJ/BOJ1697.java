package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int visited[];
    static int bush[];
    static int warp[] = {-1, 1, 2};
    public static void bfs(int start, int destination, int constrainSize){
        visited[start] = 1;
        bush[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int cs = queue.remove();
            for (int i = 0; i<3; i++){
                int vw = 0;
                if (i != 2){
                    vw = cs + warp[i];
                } else {
                    vw = cs * warp[i];
                }
                if (vw < 0 || vw >= constrainSize){
                    continue;
                }
                if (bush[vw] == 0 && visited[vw] == 0){
                    visited[vw] = 1;
                    bush[vw] = bush[cs] + 1;
                    queue.add(vw);
                }
            }
        }
        System.out.println(bush[destination] - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int size = 100001;
        visited = new int[size];
        bush = new int[size];
        bfs(N,K,size);
    }
}
