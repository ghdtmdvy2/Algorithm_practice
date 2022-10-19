package Algorithm.pr_10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static Algorithm.QuickSort.Sort;

public class QuickSort {
    public static ArrayList<Integer> quickFunc(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1) {
            return arrayList;
        }
        ArrayList<Integer> quickList = new ArrayList<>();
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        int pivot = arrayList.get(0);
        for (int i = 1; i<arrayList.size(); i++){
            if (pivot > arrayList.get(i)){
                leftList.add(arrayList.get(i));
            } else {
                rightList.add(arrayList.get(i));
            }
        }
        Collections.sort(leftList);
        Collections.sort(rightList);
        quickList.addAll(leftList);
        quickList.add(pivot);
        quickList.addAll(rightList);
        return quickList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        ArrayList<Integer> quickList = quickFunc(arrayList);
        for (int i = 0; i<quickList.size(); i++){
            System.out.println(quickList.get(i));
        }
    }
}
