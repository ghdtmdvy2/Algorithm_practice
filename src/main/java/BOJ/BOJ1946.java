package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static int people[];
    public static Company company[];
    public static class Company{
        Integer document;
        Integer interview;
        Company(Integer document, Integer interview){
            this.document = document;
            this.interview = interview;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            people = new int[N+1];
            company = new Company[N];
            for (int j = 0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                company[j] = new Company(document,interview);
            }

            Arrays.sort(company,(a,b) -> a.document - b.document);
            int min = company[0].interview;
            int cnt = 0;
            for (int j = 1; j<N; j++){
                if (min < company[j].interview){
                    cnt++;
                } else {
                    min = company[j].interview;
                }
            }


            bw.write(String.valueOf(N-cnt) +"\n");
            bw.flush();
        }
        bw.close();
    }
}
