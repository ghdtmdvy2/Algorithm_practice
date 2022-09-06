package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class simplemergeSort {

    public static void splitFunc(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1) {
            return;
        }
        int medium = arrayList.size()/2;
        // 0 부터 중간 인덱스 까지 해당 배열 아이템을 추출
        // ex) 6개의 index라면 subList의 두번째 파라미터는 그 값의 -1 을 해줘야해서 0,(3-1) 이므로 0~2까지의 index의 list를 추출한다.
        ArrayList<Integer> rightList = new ArrayList<>(arrayList.subList(0,medium));
        // 중간부터 끝 인덱스 까지 해당 배열 아이템을 추출
        // ex) 6개의 index라면 subList의 두번째 파라미터는 그 값의 -1 을 해줘야해서 3,5 이므로 3~5까지의 index의 list를 추출한다.
        ArrayList<Integer> leftList = new ArrayList<>(arrayList.subList(medium,arrayList.size()));

        System.out.println(rightList);
        System.out.println(leftList);
    }
    public static void main(String[] args) {

        splitFunc(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    }
}
