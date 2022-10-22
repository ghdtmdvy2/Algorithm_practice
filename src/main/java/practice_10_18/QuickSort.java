package practice_10_18;

import java.util.ArrayList;

import static Algorithm.QuickSort.Sort;

public class QuickSort {
    public static ArrayList<Integer> quickFunc(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1){
            return arrayList;
        }
        int pivot = arrayList.get(0);
        ArrayList<Integer> quickList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        ArrayList<Integer> leftList = new ArrayList<>();
        for (int i = 1; i <arrayList.size(); i++){
            if(pivot < arrayList.get(i)){
                rightList.add(arrayList.get(i));
            }else {
                leftList.add(arrayList.get(i));
            }
        }
        quickList.addAll(Sort(leftList));
        quickList.add(pivot);
        quickList.addAll(Sort(rightList));
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
