package pratice_10_17;

import java.util.ArrayList;

public class MergeSort {
    public static ArrayList<Integer> mergeFunc(ArrayList<Integer> arrayList){
        if (arrayList.size() <= 1){
            return arrayList;
        }
        int size = arrayList.size() / 2;

        ArrayList<Integer> rightList = mergeFunc((new ArrayList<>(arrayList.subList(0,size))));
        ArrayList<Integer> leftList = mergeFunc((new ArrayList<>(arrayList.subList(size,arrayList.size()))));

        return listCompare(leftList,rightList);
    }
    public static ArrayList<Integer> listCompare(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftSize = 0;
        int rightSize = 0;
        while (leftList.size() > leftSize && rightList.size() > rightSize){
            if (leftList.get(leftSize) > rightList.get(rightSize)){
                mergeList.add(rightList.get(rightSize));
                rightSize++;
            }
            else {
                mergeList.add(leftList.get(leftSize));
                leftSize++;
            }
        }
        while(leftList.size() > leftSize){
            mergeList.add(leftList.get(leftSize));
            leftSize++;
        }
        while(rightList.size() > rightSize){
            mergeList.add(rightList.get(rightSize));
            rightSize++;
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
