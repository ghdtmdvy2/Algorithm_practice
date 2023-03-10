package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRG12953 {
    public static int solution(int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int i = 2;
        while(true){
            int arrChange[] = new int[arr.length];
            int divLength = 0;
            // 더이상 나눌 수 없다면.
            if (i >= 100) {
                break;
            }
            for (int j = 0; j<arr.length; j++){
                if (arr[j] % i == 0) {
                    arrChange[j] = arr[j] / i;
                    divLength++;
                }
            }
            if (2 <= divLength) {
                list.add(i);
                for (int j = 0; j<arr.length; j++){
                    if (arrChange[j] != 0) {
                        arr[j] = arrChange[j];
                    }
                }
                i = 2;
            } else {
                i++;
            }
        }
        for (int j = 0; j<arr.length; j++){
            answer *= arr[j];
        }
        for (int j = 0; j<list.size(); j++){
            answer *= list.get(j);
        }
        return answer;
    }

    public static void main(String[] args) {
//        solution(new int[]{2,6,8,14});
        solution(new int[]{3,4,9,16});
    }
}
