package Algorithm;

import java.util.ArrayList;

public class MergeSort {
    // splitFunc 은 배열을 반으로 나눠주는 함수이다.
    public static ArrayList<Integer> splitFunc(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1){ // arrayList.size <= 1 이면 배열을 반으로 나눌 수 없다. ( == 재귀 함수를 빠져 나오기 위한 수단 )
            return arrayList;
        }
        int medium = arrayList.size() / 2; // 배열의 중간 index 부분

        // 매번 재귀 함수를 부르게 되어 배열의 size가 1이 되게( 배열이 최대한 쪼개지게 ) 만듦. 
        ArrayList<Integer> leftList = splitFunc(new ArrayList<>(arrayList.subList(0,medium))); // 배열의 중간으로 나눈 것에서 왼쪽 부분
        ArrayList<Integer> rightList = splitFunc(new ArrayList<>(arrayList.subList(medium, arrayList.size()))); // 배열의 중간으로 나눈 것에서 오른쪽 부분

        return mergeList(leftList, rightList);
    }

    private static ArrayList<Integer> mergeList(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        // 합칠 때 값을 비교하면서 합치기 위한 포인터(위치)를 알려주는 부분
        ArrayList<Integer> mergeList = new ArrayList<>();
        Integer leftPoint = 0;
        Integer rightPoint = 0;
        // CASE 1 : right, left 가 둘 다 있을 때 ( 아직 비교를 할 때 point 부분이 벗어나지 않았을 때 )
        while(leftList.size() > leftPoint && rightList.size() > rightPoint){
            if (leftList.get(leftPoint) > rightList.get(rightPoint)){
                mergeList.add(rightList.get(rightPoint));
                rightPoint++;
            }
            else {
                mergeList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }
        // CASE 2 : right 가 없을 때 ( right point 부분이 벗어났을 때 )
        while (leftList.size() > leftPoint ){
            mergeList.add(leftList.get(leftPoint));
            leftPoint++;
        }
        while (rightList.size() > rightPoint){
            mergeList.add(rightList.get(rightPoint));
            rightPoint++;
        }
        return mergeList;
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // CASE3: left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        mSort.mergeSplitFunc(testData);
        System.out.println(testData.toString());
        System.out.println(testData.get(0));
    }

}
