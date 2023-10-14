package programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class PRG12935 {
    public static int[] solution(int[] arr) {
        int[] answer;
        int small = arr[0];
        int smallIndex = 0;
        for (int i = 0; i<arr.length; i++) {
            if (small > arr[i]) {
                small = arr[i];
                smallIndex = i;
            }
        }
        System.out.println(smallIndex);
        if (arr.length != 1) {
            answer = new int[arr.length - 1];
            int answerIndex = 0;
            for (int i = 0; i<arr.length; i++){
                if (smallIndex == i) {
                    continue;
                } else {
                    answer[answerIndex] = arr[i];
                    answerIndex++;
                }
            }
        } else {
            answer = new int[]{-1};
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,2}));
    }
}
