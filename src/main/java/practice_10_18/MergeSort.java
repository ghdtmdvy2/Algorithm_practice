package practice_10_18;

import java.util.ArrayList;

public class MergeSort {
    public static ArrayList<Integer> mergeFunc(ArrayList<Integer> arrayList){
        if(arrayList.size() <= 1){
            return arrayList;
        }
        int size = arrayList.size() / 2;

        ArrayList<Integer> rightList = mergeFunc(new ArrayList<>(arrayList.subList(0,size)));
        ArrayList<Integer> leftList = mergeFunc(new ArrayList<>(arrayList.subList(size+1,arrayList.size())));

        return mergeList(rightList,leftList);
    }
    public static ArrayList<Integer> mergeList(ArrayList<Integer> rightList, ArrayList<Integer> leftList){
        ArrayList<Integer> mergeList = new ArrayList<>();
        int rightSize = 0;
        int leftSize = 0;
        while(rightList.size() > rightSize && leftList.size() > leftSize){
            if(rightList.get(rightSize) > leftList.get(leftSize)){
                mergeList.add(leftList.get(leftSize));
                leftSize++;
            }
            else {
                mergeList.add(rightList.get(rightSize));
                rightSize++;
            }
        }
        while(rightList.size() > rightSize){
            mergeList.add(rightList.get(rightSize));
            rightSize++;
        }
        while(leftList.size() > leftSize){
            mergeList.add(leftList.get(leftSize));
            leftSize++;
        }
        return mergeList;

    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        ArrayList<Integer> mergeList = mergeFunc(arrayList);
        for (int i = 0; i<mergeList.size(); i++){
            System.out.println(mergeList.get(i));
        }
    }
}
