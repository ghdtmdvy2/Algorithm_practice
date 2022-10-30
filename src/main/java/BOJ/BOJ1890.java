package BOJ;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/1890
class BOJ1890 {
    public static class Store{
        Integer IndexX;
        Integer IndexY;
        Integer value;
        Store(Integer IndexX,Integer IndexY, Integer value){
            this.IndexX = IndexX;
            this.IndexY = IndexY;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        ArrayList<Store> stack = new ArrayList<>();
        Store needVisit = new Store(1,1,matrix[1][1]);
        stack.add(needVisit);
        long answer = 0;

        while(stack.size() > 0){
            needVisit = stack.remove(stack.size() - 1);
            if (needVisit.value == 0 && needVisit.IndexX == N && needVisit.IndexY == N){
                answer++;
                continue;
            } else if (needVisit.value == 0){
                continue;
            }
            if (needVisit.IndexX + needVisit.value <= N){
                Store store = new Store(needVisit.IndexX + needVisit.value, needVisit.IndexY, matrix[needVisit.IndexX + needVisit.value][needVisit.IndexY]);
                stack.add(store);
            }

            if (needVisit.IndexY + needVisit.value <= N){
                Store store = new Store(needVisit.IndexX , needVisit.IndexY + needVisit.value, matrix[needVisit.IndexX][needVisit.IndexY+ needVisit.value]);
                stack.add(store);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}