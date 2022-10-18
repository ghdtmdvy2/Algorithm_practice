package pratice_10_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static boolean searchItem(ArrayList<Integer> arrayList, Integer searchItem){
        if (arrayList.size() == 1 && arrayList.get(0) == searchItem){
            return true;
        }
        if (arrayList.size() == 1 && arrayList.get(0) != searchItem){
            return false;
        }
        if (arrayList.size() == 0){
            return false;
        }
        Integer midSize = arrayList.size() / 2;
        Integer mid = arrayList.get(midSize);
        if (searchItem == mid){
            return true;
        }
        if (searchItem < mid){
            return searchItem(new ArrayList<>(arrayList.subList(0,midSize)),searchItem);
        } else {
            return searchItem(new ArrayList<>(arrayList.subList(midSize,arrayList.size())),searchItem);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        Collections.sort(testData);
        System.out.println(testData);
        System.out.println(searchItem(testData,34));
    }
}
