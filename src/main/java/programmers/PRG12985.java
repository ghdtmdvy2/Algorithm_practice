package programmers;

public class PRG12985 {
    public static int solution(int n, int a, int b)
    {
        int answer = 1;
        int winA = a;
        int winB = b;
        while(winA != winB) {
            int divA = winA / 2;
            int modA = winA % 2;
            int divB = winB / 2;
            int modB = winB % 2;
            winA = divA + modA;
            winB = divB + modB;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(8,4,7);
    }
}
