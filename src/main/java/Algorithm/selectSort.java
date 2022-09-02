package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class selectSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }

        for (int i = 0; i < arrayList.size(); i++){
            for (int j = i + 1; j < arrayList.size(); j++){
                if (arrayList.get(i) < arrayList.get(j)){
                    Collections.swap(arrayList,i,j);
                }
            }
        }
        for (int i = 0; i < 100; i++){
            System.out.println(arrayList.get(i));
        }
    }
}
