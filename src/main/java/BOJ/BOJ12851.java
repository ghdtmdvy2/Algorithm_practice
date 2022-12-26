package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    static int visited[];
    static int bush[];
    static int warp[] = {-1, 1, 2};
    public static void bfs(int start, int destination, int constrainSize){
        visited[start] = 1;
        bush[start] = 1;
        int cnt = 0;
        if (start == destination) {
            cnt = 1;
        }
        int chk = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int cs = queue.remove();
            int vw = 0;
            for (int i = 0; i<3; i++){
                if (i != 2){
                    vw = cs + warp[i];
                } else {
                    vw = cs * warp[i];
                    if (vw == cs+warp[i-1] || vw == cs+warp[i-2]) {
                        visited[vw] = 0;
                    }
                }
                if (vw < 0 || vw >= constrainSize){
                    continue;
                }
                if (visited[vw] != 0 && bush[cs] + 1 == bush[vw] && vw == destination) {
                    cnt++;
                }
                if (visited[vw] == 0){
                    if (vw == destination) {
                        cnt++;
                    }
                    visited[vw] = 1;
                    bush[vw] = bush[cs] + 1;
                    queue.add(vw);
                }
            }
        }
        System.out.println(bush[destination] - 1);
        System.out.println(cnt);
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
