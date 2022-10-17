package pratice_10_17;

import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        for (int i = 2; i < arrayList.size(); i++){
            for (int j = i; j > 0; j--){
                if (arrayList.get(j) < arrayList.get(j-1)){
                    Collections.swap(arrayList,j,j-1);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}
