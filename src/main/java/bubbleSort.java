import java.util.ArrayList;
import java.util.Collections;

public class bubbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        boolean swap;
        for (int i = 0; i < arrayList.size(); i++){
            swap = false;
            for (int j = 0; j < arrayList.size() - 1 - i; j++){
                if (arrayList.get(j) < arrayList.get(j+1)){
                    Collections.swap(arrayList,j,j+1);
                    swap = true;
                }
            }
            if (swap == false){
                break;
            }
        }
        for (int i = 0; i < 100; i++){
            System.out.println(arrayList.get(i));
        }
    }
}
