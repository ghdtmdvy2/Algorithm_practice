package codingtest;

public class DDCT2 {
    public int solution(int n) {
        int answer = 0;
        // 해당 숫자를 String 에서의 split 기능을 사용하기 위해 int 를 String 으로 바꾼 뒤 split.
        String nString[] = String.valueOf(n).split("");
        for (String v : nString) {
            // 해당 자릿 수 값(split 한 값)을 int 타입으로 변형해주어 값을 더해줌.
            answer += Integer.parseInt(v);
        }

        return answer;
    }
}