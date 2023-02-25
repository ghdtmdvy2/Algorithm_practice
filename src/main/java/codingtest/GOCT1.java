package codingtest;

public class GOCT1 {
    static int alpha[] = new int['z' - 'a' + 1];
    public static int solution(String s) {
        int answer = 0;
        String[] split = s.split("");
        for (String sb : split){
            int index = 'z' - sb.charAt(0);
            alpha[index]++;
        }
        for (int i = 0; i<alpha.length; i++){
            if (alpha[i] == 0) {
                continue;
            }
            if (alpha[i] % 2 == 1){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbbccd"));
        System.out.println(solution("abebeaedeac"));
        System.out.println(solution("z"));
    }
}
