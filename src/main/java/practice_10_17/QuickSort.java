package practice_10_17;

import java.util.ArrayList;

import static Algorithm.QuickSort.Sort;

public class QuickSort {
    public static ArrayList<Integer> QuickFunc(ArrayList<Integer> arrayList){
        if (arrayList.size() == 1){
            return arrayList;
        }
        ArrayList<Integer> mergeList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        ArrayList<Integer> leftList = new ArrayList<>();
        int pivot = arrayList.get(0);
        for (int i = 1; i<arrayList.size(); i++){
            if (arrayList.get(i) <= pivot){
                rightList.add(arrayList.get(i));
            }
            else {
                leftList.add(arrayList.get(i));
            }
        }
        mergeList.addAll(Sort(rightList));
        mergeList.add(pivot);
        mergeList.addAll(Sort(leftList));

        return mergeList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        ArrayList<Integer> mergeList = QuickFunc(arrayList);
        for (int i = 0; i<mergeList.size(); i++){
            System.out.println(mergeList.get(i));
        }
    }
}
