package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1439 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String sBits[] = s.split("");
        int oneLength = 0;
        int zeroLength = 0;
        int cnt = 0;
        String prev;

        prev = sBits[0];
        List<String> list = new ArrayList<>();
        list.add(prev);
        for(int i = 1; i<sBits.length; i++){
            if (!prev.equals(sBits[i]) && Integer.parseInt(sBits[i]) == 0) {
                prev = sBits[i];
                list.add(sBits[i]);
            }
            if (!prev.equals(sBits[i]) && Integer.parseInt(sBits[i]) == 1) {
                prev = sBits[i];
                list.add(sBits[i]);
            }
        }
        for (int i = 0; i<list.size(); i++){
            if (Integer.parseInt(list.get(i)) == 0){
                zeroLength++;
            } else if (Integer.parseInt(list.get(i)) == 1) {
                oneLength++;
            }
        }
        if (zeroLength > oneLength){
            System.out.println(oneLength);
        } else {
            System.out.println(zeroLength);
        }
    }
}
