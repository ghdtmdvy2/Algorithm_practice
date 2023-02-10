package codingtest;
//- n일 동안 여행을 가면 휴일의 최댓 값 최솟값 구하기
// EX) 6일 동안 여행간다고 하면
//- 월, 화, 수, 목, 금, 토 는 휴일을 하루 쓰는 것 해당
//- 기간 조정하면  화, 수, 목, 금, 토, 일은 휴일을 이틀 쓰는 것으로 해당.
public class CT2 {
    public static int[] solution(long n) {
        int answer[] = {0,0};
        long dayDiv = n / 7;
        long dayMod = n % 7;
        if (dayDiv == 0) {
            answer[1] += dayDiv;
            answer[0] += dayDiv;
        }
        else if (dayMod == 0) {
            answer[1] += 2 * dayDiv;
            answer[0] += 2 * dayDiv;
            return answer;
        }else {
            answer[1] += 2 * dayDiv;
            answer[0] += 2 * dayDiv;
        }
        if (dayMod == 1) {
            answer[1] += 1;
        } else if (7 != n){
            answer[1] += 2;
        }
        if (dayMod == 6) {
            answer[0] += 1;
        }
        return answer;
    }
}
