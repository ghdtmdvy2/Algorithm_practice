package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PRG43163 {
    static Queue<String> queue = new LinkedList<>();
    static Queue<Integer> queueInt = new LinkedList<>();
    static int[] check;
    public static int bfs(String target, String[] words){
        while(!queue.isEmpty()){
            String s = queue.remove();
            String sBits[] = s.split("");
            int wi = queueInt.remove();
            for (int i = 0; i<words.length; i++){
                int index = 0;
                int cnt = 0;
                if (words[i].length() < 3 || words[i].length() > 10) {
                    continue;
                }
                if (check[i] == 0) {
                    String ws = words[i];
                    String wsBits[] = ws.split("");

                    for (String wsBit : wsBits) {
                        if(!(wsBit.equals(sBits[index]))){
                            cnt++;
                        }
                        index++;
                    }
                }
                if (cnt == 1) {
                    check[i] = check[wi] + 1;
                    if (words[i].equals(target)) {
                        return check[i];
                    }
                    queue.add(words[i]);
                    queueInt.add(i);
                }
            }
        }
        return 0;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        check = new int[words.length];
        queue.add(begin);
        queueInt.add(0);
        answer = bfs(target,words);
        return answer;
    }
}
