import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    // 대부분 힙 자료구조는 배열로 구현한다.
    ArrayList<Integer> heapArray = null;
    public Heap(Integer data){
        heapArray = new ArrayList<>();
        // 부모 index, 자식 index 값을 구하기 편하게 첫번째 값은 null로 넣어주는 과정을 해준다.
        heapArray.add(null);
        heapArray.add(data);
    }
    public boolean insert(Integer data){
        if (heapArray == null){
            heapArray.add(null);
            heapArray.add(data);
            return true;
        } else {
            heapArray.add(data);
            Integer insert_idx = heapArray.size() - 1;
            while(moveUp(insert_idx)){
                Integer Parent_idx = insert_idx / 2;
                Collections.swap(heapArray,insert_idx, Parent_idx);
                insert_idx = Parent_idx;
            }
            return true;
        }
    }

    private boolean moveUp(Integer insert_idx) {
        if (insert_idx <= 1){
            return false;
        } else {
            Integer Parent_idx = insert_idx / 2;
            if (heapArray.get(insert_idx) < heapArray.get(Parent_idx)){
                return false;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);
    }
}
