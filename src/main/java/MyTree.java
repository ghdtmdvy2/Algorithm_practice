
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
                    if (node.left != null){
                        node = node.left;
                    }
                    else {
                        node.left = new Node(value);
                        break;
                    }
                } else {
                    if (node.right != null){
                        node = node.right;
                    }
                    else {
                        node.right = new Node(value);
                        break;
                    }
                }
            }
        }
        return true;
    }
    public Node search(int value){
        if (head == null){
            return null;
        }
        else {
            Node node = head;
            while(node != null) {
                if (node.value == value) {
                    return node;
                } else if (node.value > value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);
        Node testNode = myTree.search(3);
        System.out.println(testNode.value);
    }
}
