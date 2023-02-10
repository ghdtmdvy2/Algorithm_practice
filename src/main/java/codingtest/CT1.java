package codingtest;
// 배열에 있는 수 arrA 를 회전해서 arrB 에 수가 같게 나오면 true 아니면 false를 반환 하시오.
// test 1
//   - arrA : [ 4,3,2,1 ], arrB : [5, 4, 1, 2]
//   - return : false
// test 2
//    - arrA : [ 7,8,10 ], arrB : [ 10, 7, 8]
//    - return : true
// test 3
//    - arrA : [ 4,3,2,1 ], arrB : [ 3, 2, 1, 4 ]
//    - return : true
public class CT1 {
    public static boolean solution(int[] arrA, int[] arrB) {
        boolean answer = false;
        int reverseCnt = arrA.length;
        if (arrA.length != arrB.length) {
            return false;
        } else {
            while(reverseCnt > 0){
                reverseCnt--;
                int start = arrA[0];
                int cnt = 0;
                if (arrA[0] == arrB[arrA.length - 1]) {
                    cnt++;
                }
                for (int i = 0; i<arrB.length-1; i++){
                    if (arrB[i] != arrA[i+1]) {
                        cnt--;
                    }
                    cnt++;
                    arrA[i] = arrA[i + 1];
                }
                arrA[arrB.length - 1] = start;
                if (cnt == arrA.length) {
                    answer = true;
                    break;
                }
            }
        }

        return answer;
    }
}
