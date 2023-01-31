package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PRG12977 {
    static Set<Integer> set = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    public boolean decimal(int value){
        int cnt = 0;
        for (int i = 2; i<=value; i++){
            if (value % i == 0) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return true;
        }
        return false;
    }
    public int solution(int[] nums) {
        int answer = 0;

        // 1,2 3 4
        // 2,3 4
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = i + 2; k < nums.length; k++) {


                    if (i >= j || i >= k || j >= k) {
                        continue;
                    }
                    int decimalChk = nums[i] + nums[j] + nums[k];
                    if (decimal(decimalChk)) {
                        list.add(decimalChk);
                    }
                }
            }
        }
        answer = list.size();
        // 1,2 3 4 5
        // 2,3 4 5
        // 3,4 5


        return answer;
    }
}
