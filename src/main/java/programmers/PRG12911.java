package programmers;

public class PRG12911 {
    public static int solution(int n) {
        int answer = 0;
        // 조건 1. n 의 다음 큰 숫자는 n보다 큰 자연수 입니다.
        // 조건 2. n 의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
        // 조건 3. n 의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
        int nBitCount = Integer.bitCount(n);
        while(true) {
            n++;
            int bitCount = Integer.bitCount(n);
            if (bitCount == nBitCount) {
                break;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}
