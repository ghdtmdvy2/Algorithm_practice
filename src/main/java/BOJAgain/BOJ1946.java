package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1946 {
    static class People implements Comparable<People>{
        int document;
        int interview;
        People (int document, int interview){
            this.document = document;
            this.interview = interview;
        }
        public int compareTo(People o){
            if (this.document < o.document){
                return -1;
            } else {
                return 1;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<People> peoples = new PriorityQueue<>();
            for (int j = 0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                People people = new People(document,interview);
                peoples.add(people);
            }
            int cnt = 0;
            int prev = peoples.peek().interview;
            while (peoples.size() >= 2){
                prev = Math.min(prev,peoples.poll().interview);
                People people = peoples.peek();
                if (people.interview > prev){
                    cnt++;
                }
            }
            System.out.println(N-cnt);
        }
    }
}
