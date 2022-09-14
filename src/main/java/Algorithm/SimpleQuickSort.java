package Algorithm;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleQuickSort {
    public static void addSort(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1){
            return;
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
            mergedList.addAll(leftArrayList);
            // Arrays.asList 는 어떤 값을 List 형태로 만들게 해준다.
            mergedList.addAll(Arrays.asList(pivot));
            mergedList.addAll(rightArrayList);

            System.out.println(mergedList);
        }
    }

    public static void main(String[] args) {
        Integer list[] = {4,1,2,5,7};
        SimpleQuickSort.addSort(new ArrayList<>(Arrays.asList(list)));
    }
}
