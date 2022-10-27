package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1292
class BOJ1292 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int addNumber = 0;
        for (int i = 1; i<=B; i++){
            addNumber = i;
            for (int j = 1; j<=i; j++){
                if (list.size() == B){
                    break;
                }
                list.add(addNumber);

            }
        }
        int answer = 0;
        for (int i = A-1; i<=B-1; i++){
            answer += list.get(i);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}