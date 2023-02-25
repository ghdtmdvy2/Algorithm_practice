package codingtest;

import java.util.ArrayList;
import java.util.List;

class GOCT2 {
    public int solution(long n) {
        int answer = 0;
        long value = n;
        // 각 자리의 숫자를 저장하기 위한 list
        List<Long> list = new ArrayList<>();
        while (value > 0) {
            // 각 자리수를 출력하기 위한 값.
            long mod = value % 10;
            // 각 자리수가 '0' 이 아니면서 (조건에 0으로 나눌 수 없음을 유의라는 말에 추가.)
            // 각 자리의 숫자가 중복해서 저장이 되지 않기 때문에 list.contains 를 통해 확인하면서 list 저장.
            if (mod!= 0 && !list.contains(mod)){
                list.add(mod);
            }
            // 각 자리의 숫자에 따른 처리가 끝났으면 값을 10으로 나누어 다시 세팅.
            value = value / 10;
        }
        // 이제 그 자리수가 나누어 떨어지는 지 확인하는 반복문.
        for (int i = 0; i<list.size(); i++){
            if (n % list.get(i) == 0) {
                answer++;
            }
        }
        return answer;
    }
}