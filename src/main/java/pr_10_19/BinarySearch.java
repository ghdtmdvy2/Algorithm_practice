package pr_10_19;

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
        int mid = arrayList.size() / 2;
        if(arrayList.get(mid) == searchItem){
            return true;
        }
        if (arrayList.get(mid) < searchItem){
            return searchItem(new ArrayList<>(arrayList.subList(mid,arrayList.size())),searchItem);
        } else {
            return searchItem(new ArrayList<>(arrayList.subList(0,mid)),searchItem);
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
