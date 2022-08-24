public class MyTree {
    Node head = null;
    public class Node{
        Node left;
        Node right;
        int value;
        public Node (int value){
            this.value = value;
        }
    }
    public boolean insertNode(int value){
        if (head == null){
            head = new Node(value);
        }
        else {
            Node node = head;
            while(true){
                // 현재 노드 값보다 큰 경우 왼쪽으로 큰 경우 오른쪽으로 저장
                if (node.value > value){
                    node = node.left;
                    if (node == null) {
                        node = new Node(value);
                        break;
                    }
                } else {
                    node = node.right;
                    if (node == null) {
                        node = new Node(value);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);
    }
}
