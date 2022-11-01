package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int matrix[][];
    static int visited[][];
    public static void DFS(int x, int y,int constrainX, int constrainY){
        int cx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
        int cy[] = { 1,  0, -1,-1,-1, 0, 1, 1};
        int searchX = x;
        int searchY = y;
        visited[x][y] = 0;
        for (int i = 0; i<=7; i++){
            if (searchY+cy[i] <= 0 || searchX+cx[i] <= 0 || searchX+cx[i] > constrainX || searchY+cy[i] > constrainY){
                continue;
            }
            if (visited[searchX+cx[i]][searchY+cy[i]] == 1 && matrix[searchX+cx[i]][searchY+cy[i]] == 1){
                visited[searchX+cx[i]][searchY+cy[i]] = 0;
                DFS(searchX+cx[i],searchY+cy[i],constrainX,constrainY);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;
            if (N == 0 && M == 0){
                break;
            }
            matrix = new int[M+1][N+1];
            visited = new int[M+1][N+1];
            for (int i = 1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j<=N; j++){
                    int land = Integer.parseInt(st.nextToken());
                    matrix[i][j] = land;
                    visited[i][j] = land;
                }
            }
            for(int i = 1; i<=M; i++){
                for(int j = 1; j<=N; j++){
                    if (visited[i][j] == 1){
                        answer++;
                        DFS(i,j,M,N);
                    }
                }
            }
            bw.write(String.valueOf(answer)+ "\n");
            bw.flush();
        }
        bw.close();
    }
}
