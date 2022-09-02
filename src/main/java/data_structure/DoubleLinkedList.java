package data_structure;

public class DoubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    public void addNode(T data){
        if (head == null){
            head = new Node<>(data);
            tail = head;
        }
        else {
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            tail = node.next;
        }
    }
    public T SearchHeadData(T isData){
        if (head == null){
            return null;
        }
        else {
            Node<T> node = head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                }
                node = node.next;
            }
            return null;
        }
    }

    public T SearchTailData(T isData){
        if (head == null){
            return null;
        }
        else {
            Node<T> node = tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                }
                node = node.prev;
            }
            return null;
        }
    }
    public void printAll(){
        if (head != null){
            Node<T> node = head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
    public class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;
        Node(T data){
            this.data = data;
            prev = null;
            next = null;
        }
    }
    public boolean insertToFront(T data, T isData){
        Node<T> node = head;
        if (head == null){
            head = new Node<>(data);
            tail = head;
            return false;
        }
        else {
            if (head.data == isData){
                Node<T> InsNode = new Node<>(data);
                InsNode.next = head;
                head = InsNode;
            }
            else {
                while(node != null){
                    if (node.data == isData){
                        Node<T> PrevNode = node.prev;
                        PrevNode.next = new Node<>(data);
                        PrevNode.next.next = node;
                        PrevNode.next.prev = PrevNode;
                        node.prev = PrevNode.next;

                        return true;
                    }
                    node = node.next;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }
}
