package data_structure;

import java.util.ArrayList;

public class MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T i){
        queue.add(i);
    }
    public T dequeue(){
        Object leng = queue.size();
        if (leng == null){
            return null;
        }
        return queue.remove(0);
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}