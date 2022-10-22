package practice_10_17;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 99 - i; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    Collections.swap(arrayList, j, j + 1);
                }
            }
        }
        for (int i = 0; i<100; i++){
            System.out.println(arrayList.get(i));
        }
    }
}
