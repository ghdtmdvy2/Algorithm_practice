package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1012 {
    static ArrayList<adjacent> needVisit = new ArrayList<>();
    static int visited[][];
    static int M;
    static int N;
    static int field[][];
    public static class adjacent{
        Integer IndexX;
        Integer IndexY;
        adjacent(Integer IndexX, Integer IndexY){
            this.IndexX = IndexX;
            this.IndexY = IndexY;
        }

    }
    public static void dfs(){
        while(needVisit.size() > 0){
            adjacent path = needVisit.remove(needVisit.size()-1);

            if(path.IndexX+1 <= M-1 && visited[path.IndexX+1][path.IndexY] != 1 && field[path.IndexX+1][path.IndexY] == 1){
                adjacent ap = new adjacent(path.IndexX+1,path.IndexY);
                visited[path.IndexX+1][path.IndexY] = 1;
                needVisit.add(ap);
            }
            if(path.IndexX-1 >= 0 && visited[path.IndexX-1][path.IndexY] != 1  && field[path.IndexX-1][path.IndexY] == 1){
                adjacent ap = new adjacent(path.IndexX-1,path.IndexY);
                visited[path.IndexX-1][path.IndexY] = 1;
                needVisit.add(ap);
            }
            if (path.IndexY+1 <= N-1 && visited[path.IndexX][path.IndexY+1] != 1 &&  field[path.IndexX][path.IndexY+1] == 1){
                adjacent ap = new adjacent(path.IndexX,path.IndexY+1);
                visited[path.IndexX][path.IndexY+1] = 1;
                needVisit.add(ap);
            }
            if (path.IndexY-1 >= 0 && visited[path.IndexX][path.IndexY-1] != 1 &&  field[path.IndexX][path.IndexY-1] == 1){
                adjacent ap = new adjacent(path.IndexX,path.IndexY-1);
                visited[path.IndexX][path.IndexY-1] = 1;
                needVisit.add(ap);
            }


        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int min = 0;
        int start = 0;
        int prevIndexX = 0,prevIndexY = 0;
        for(int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int bug = Integer.parseInt(st.nextToken());
            field = new int[M][N];
            visited = new int[M][N];
            min = 0;
            for (int j = 0; j<bug; j++){
                st = new StringTokenizer(br.readLine());
                int adjacentIndexX = Integer.parseInt(st.nextToken());
                int adjacentIndexY = Integer.parseInt(st.nextToken());
                field[adjacentIndexX][adjacentIndexY] = 1;
            }
            for (int j = 0; j<M; j++){
                for (int k = 0; k<N; k++){
                    if(field[j][k] == 1 && visited[j][k] == 0){
                        needVisit.add(new adjacent(j,k));
                        dfs();
                        min++;
                    }
                }
            }

            bw.write(String.valueOf(min)+"\n");
            bw.flush();
        }
        bw.close();
    }
}
