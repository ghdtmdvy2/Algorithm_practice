package pratice_10_17;

import java.util.ArrayList;
import java.util.Collections;

public class InsertSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        int min = 0;
        for (int i = 0; i < arrayList.size(); i++){
            min = i;
            for (int j = i; j < arrayList.size(); j++){
                if (arrayList.get(min) > arrayList.get(j)){
                    min = j;
                }
            }
            Collections.swap(arrayList, min, i);
        }
        for (int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}
