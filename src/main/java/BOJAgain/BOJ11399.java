package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<N; i++){
            int time = Integer.parseInt(st.nextToken());
            list.add(time);
        }
        Collections.sort(list);
        int ans = list.get(0);
        for (int i = 0; i<N-1; i++) {
            int p1 = list.remove(0);
            int p2 = list.get(0);
            int sum = p1 + p2;
            list.set(0,sum);
            ans += sum;
        }
        System.out.println(ans);
    }
}
