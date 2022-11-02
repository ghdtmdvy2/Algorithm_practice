package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        List<Long> list = new ArrayList<>();
        list.add(B);
        while(B > 0){
            if (B % 2 == 0){
                B = B / 2;
                list.add(B);
            } else if (B % 10 == 1){
                B = B / 10;
                if (B == 0){
                    break;
                }
                list.add(B);
            } else {
                break;
            }
        }
        int answer = 0;
        int Index = 0;
        for (int i = 0; i<list.size(); i++){
            if (A == list.get(i)){
                Index = i;
                break;
            }
        }
        if (Index != 0){
            System.out.println(Index+1);
        } else {
            System.out.println(-1);
        }
    }
}
