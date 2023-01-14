package BOJAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String o = br.readLine();
        String s[] = o.split("-");
        int ans = 0;
        if (s.length == 1) {
            String sb[] = s[0].split("\\+");
            for (String s1 : sb) {
                ans += Integer.parseInt(s1);
            }
            System.out.println(ans);
            return;
        }
        for (int i = 0; i<s.length; i++){
            String v[] = s[i].split("\\+");
            if (i == 0) {
                for (int j = 0; j<v.length; j++) {
                    ans += Integer.parseInt(v[j]);
                }
                continue;
            }
            for (int j = 0; j<v.length; j++) {
                ans += Integer.parseInt(v[j]) * (-1);
            }
        }
        System.out.println(ans);
    }
}
