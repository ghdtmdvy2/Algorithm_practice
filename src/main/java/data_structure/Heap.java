package data_structure;

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

    public Integer pop(){
        if (heapArray == null){
            return null;
        } else {
            Integer return_data, popped_idx, child_left_idx, child_right_idx;
            return_data = heapArray.get(1);
            heapArray.set(1,heapArray.get(heapArray.size() - 1));
            heapArray.remove(heapArray.size() - 1);
            popped_idx = 1;
            while(move_down(popped_idx)){
                child_left_idx = popped_idx * 2;
                child_right_idx = popped_idx * 2 + 1;
                // CASE 2 : 왼쪽 노드만 존재
                if (heapArray.size() <= child_right_idx) {
                    Collections.swap(heapArray,popped_idx,child_left_idx);
                }
                // CASE 3 : 오른쪽 노드만 존재
                else {
                    if (heapArray.get(child_right_idx) >= heapArray.get(popped_idx)){
                        Collections.swap(heapArray,popped_idx,child_right_idx);
                    } else {
                        Collections.swap(heapArray,popped_idx,child_left_idx);
                    }
                }
            }
            return return_data;
        }
    }

    public boolean move_down(Integer parent_idx){
        if (heapArray == null) {
            return false;
        } else {
            Integer left_child_idx = parent_idx * 2;
            Integer right_child_idx = parent_idx * 2 + 1;
            // CASE 1 : 하나도 없을 경우 (leaf Node)
            if (heapArray.size() <= left_child_idx) {
                return false;
            }
            // CASE 2 : 왼쪽 노드만 있을 경우
            else if (heapArray.size() <= right_child_idx) {
                if (heapArray.get(left_child_idx) >= heapArray.get(parent_idx)){
                    return true;
                }
                else {
                    return false;
                }
            }
            // CASE 3 : 양쪽 다 있을 경우
            else {
                if (heapArray.get(right_child_idx) >= heapArray.get(parent_idx)){
                    return true;
                } else if (heapArray.get(left_child_idx) >= heapArray.get(parent_idx)){
                    return true;
                } else {
                    return false;
                }
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

        System.out.println(heapTest.pop());
        System.out.println(heapTest.heapArray);

        System.out.println(heapTest.pop());
        System.out.println(heapTest.heapArray);

        System.out.println(heapTest.pop());
        System.out.println(heapTest.heapArray);

        System.out.println(heapTest.pop());
        System.out.println(heapTest.heapArray);
        System.out.println(heapTest.pop());
        System.out.println(heapTest.heapArray);
        System.out.println(heapTest.pop());
        System.out.println(heapTest.heapArray);
    }
}
