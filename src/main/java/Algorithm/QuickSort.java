package Algorithm;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static ArrayList<Integer> Sort(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1){
            return arrayList;
        } else {
            Integer pivot = arrayList.get(0);
            ArrayList<Integer> leftArrayList = new ArrayList<>();
            ArrayList<Integer> rightArrayList = new ArrayList<>();
            for (int i = 1; i <arrayList.size(); i++){
                if (arrayList.get(i) <= pivot){
                    leftArrayList.add(arrayList.get(i));
                } else {
                    rightArrayList.add(arrayList.get(i));
                }
            }
            ArrayList<Integer> mergedList = new ArrayList<>();
            // addAll은 List 안에 List를 넣으면 알아서 값으로 넣게 해준다.
            mergedList.addAll(Sort(leftArrayList));
            // Arrays.asList 는 어떤 값을 List 형태로 만들게 해준다.
            mergedList.addAll(Arrays.asList(pivot));
            mergedList.addAll(Sort(rightArrayList));

            return mergedList;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        ArrayList<Integer> arrayList = QuickSort.Sort(testData);
        System.out.println(arrayList);
    }
}
