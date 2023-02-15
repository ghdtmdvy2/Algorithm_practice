package programmers;

public class PRG70129 {
    public static int[] solution(String s) {
        int[] answer = {0,0};
        StringBuilder binaryPrev = new StringBuilder(s);
        while (binaryPrev.length() > 1) {
            answer[0]++;
            int zeroLength = 0;
            for (int i = 0; i<binaryPrev.length(); i++){
                if (binaryPrev.charAt(i) == '1') {
                    zeroLength++;
                } else {
                    answer[1]++;
                }
            }
            binaryPrev = new StringBuilder(Integer.toBinaryString(zeroLength));
        }
        return answer;
    }

    public static void main(String[] args) {
        solution("110010101001");
    }
}
