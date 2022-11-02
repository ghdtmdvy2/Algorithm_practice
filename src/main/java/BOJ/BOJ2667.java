package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2667 {
    static int matrix[][];
    static int visited[][];
    static List<Integer> answer = new ArrayList<>();
    static int cnt = 0;
    public static void DFS(Integer searchX, Integer searchY,Integer constrainX, Integer constrainY){
        int cx[] = {0,1, 0,-1};
        int cy[] = {1,0,-1, 0};

        for (int i = 0; i<4; i++){
            if (searchX+cx[i] > 0
                    && searchX+cx[i] <= constrainX
                    && searchY+cy[i] > 0
                    && searchY+cy[i] <= constrainY
                    && visited[searchX+cx[i]][searchY+cy[i]] == 0
                    && matrix[searchX+cx[i]][searchY+cy[i]] == 1) {
                visited[searchX+cx[i]][searchY+cy[i]] = 1;
                cnt++;
                DFS(searchX+cx[i],searchY+cy[i],constrainX,constrainY);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1];
        visited = new int[N+1][N+1];
        for (int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String houses[] = st.nextToken().split("");
            for(int j = 1; j<=N; j++){
                matrix[i][j] = Integer.parseInt(houses[j-1]);
            }
        }
        for (int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if (visited[i][j] == 0 && matrix[i][j] == 1){
                    visited[i][j] = 1;
                    cnt++;
                    DFS(i,j,N,N);
                    answer.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(answer);
        bw.write(String.valueOf(answer.size())+ "\n");
        for (int i = 0; i<answer.size(); i++){
            bw.write(String.valueOf(answer.get(i))+ "\n");
        }
        bw.flush();
        bw.close();
    }
}
