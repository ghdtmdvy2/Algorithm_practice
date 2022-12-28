package PCCP;

public class PCCP_2_1 {
    public int[] solution(String command) {
        int answer[] = new int[2];
        String[] cBits = command.split("");
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int cnt = 0;
        for (String bit : cBits){
            int index = 0;
            if (cnt < 0) {
                int div = Math.abs(cnt) / 4;
                int mod = Math.abs(cnt) % 4;
                if (mod == 0) {
                    div--;
                }
                index = cnt + ((div + 1) * 4);
            } else {
                index = cnt % 4;
            }

            if (bit.equals("R")) {
                cnt++;
            }
            else if (bit.equals("L")) {
                cnt--;
            }
            else if (bit.equals("G")){
                answer[0] = answer[0] + dx[index];
                answer[1] = answer[1] + dy[index];
            } else {
                int e = 0;
                if (index == 0) {
                    e = index + 2;
                } else if (index == 1) {
                    e = index + 2;
                } else {
                    e = (index+2) % 4;
                }
                answer[0] = answer[0] + dx[e];
                answer[1] = answer[1] + dy[e];
            }
        }
        return answer;
    }
}
