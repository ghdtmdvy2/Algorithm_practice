public class SingleLinkedList <T> {
    private Node<T> head = null;
    public class Node<T>{
        private T data;
        private Node<T> next = null;
        Node(T data){
            this.data = data;
        }
    }
    public void printAll(){
        Node<T> node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }


    private Node<T> searchNode(T data) {
        Node<T> node = head;
        while(node.next != null){
            if (node.data == data){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void addNode(T data){
        if (head == null){
            head = new Node<>(data);;
        }
        else {
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public boolean insertNode(T data, T isData){
        Node<T> searchNode = searchNode(data);
        if (searchNode == null){
            return false;
        }
        else {
            Node<T> nextNode = searchNode.next;
            searchNode.next = new Node<>(isData);
            searchNode.next.next = nextNode;
            return true;
        }
    }
    public boolean delNode(T data){

        if (head == null){
            return false;
        }
        else {
            Node<T> node = head;
            if (node.data == data){
                head = head.next;
                return true;
            }
            else {
                while(node.next != null){
                    if (node.next.data == data){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(3);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(1);
        System.out.println(singleLinkedList.insertNode(3,20));
        System.out.println(singleLinkedList.insertNode(6,30));
        System.out.println(singleLinkedList.delNode(3));
        System.out.println(singleLinkedList.delNode(2));
        System.out.println(singleLinkedList.delNode(20));
        System.out.println(singleLinkedList.delNode(1));
        singleLinkedList.printAll();
    }
}
