package programmers;
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class PRG43165 {
    static int cal[];
    static int calAns[] = {1,-1};
    static int ans = 0;
    public static void calculate(int val, int dest, int cnt, int limitCnt, int[] numbers) {
        if (cnt == limitCnt) {
            if (val == dest) {
                ans++;
            }
            return;
        }
        for (int i = 0; i<2; i++){
            if (cal[i] == 0) {
                continue;
            }
            int sum = 0;
            cal[i]--;
            sum = val + numbers[cnt] * calAns[i];
            calculate(sum,dest,cnt + 1, limitCnt, numbers);
            cal[i]++;
        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        cal = new int[2];
        for (int i = 0; i<=numbers.length; i++){
            cal[0] = i;
            cal[1] = numbers.length - i;
            calculate(0,target,0,numbers.length,numbers);
        }
        answer = ans;
        return answer;
    }
}
