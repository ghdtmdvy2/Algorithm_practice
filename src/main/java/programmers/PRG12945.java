package programmers;

public class PRG12945 {
    public static int fibo(int n){
        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        return fibo(n-2) + fibo(n-1);
    }
    public static int solution(int n) {
        int answer = 0;
        int fibo[] = new int[100001];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i<=n; i++){
            fibo[i] = (fibo[i-2] + fibo[i-1]) % 1234567;
        }
        answer = fibo[n] % 1234567;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
