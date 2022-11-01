package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String equationMinus = br.readLine();
        String equationBits[] = equationMinus.split("-");
        // + 만 있는 경우.


        List<Integer> sums = new ArrayList<>();
        int Symbol = 0;
        for (String equationBit : equationBits){
            if(equationBit.trim().length() == 0){
                Symbol = 1;
                continue;
            }
            String[] split = equationBit.split("\\+");
            if (split.length == 1){
                sums.add(Integer.parseInt(split[0]));
                continue;
            }
            int sum = 0;
            for (String plus : split){
                sum = sum + Integer.parseInt(plus);
            }
            sums.add(sum);
        }
        int answer = 0;
        for (int i = 0; i<sums.size(); i++){
            if (i == 0){
                if (Symbol == 1){
                    answer = answer - sums.get(0);
                } else {
                    answer = answer + sums.get(0);
                }

            } else {
                answer = answer - sums.get(i);
            }

        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
