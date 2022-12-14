package data_structure;

public class MyTree {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insertNode(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node node = head;
            while (true) {
                // 현재 노드 값보다 큰 경우 왼쪽으로 큰 경우 오른쪽으로 저장
                if (node.value > value) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new Node(value);
                        break;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new Node(value);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int value) {
        if (head == null) {
            return null;
        } else {
            Node node = head;
            while (node != null) {
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

    public boolean delete(int value) {
        // 삭제할 데이터를 찾았을 때를 check
        boolean search = false;
        Node currParentNode = head;
        Node currNode = head;
        // 1. head가 null 인 경우
        if (head == null) {
            return false;
        }
        // 2. head가 null 이 아닌 경우
        else {
            // head
            if (head.value == value) {
                if (head.right == null && head.left == null) {
                    head = null;
                    return true;
                }
            }
            while (currNode != null) {
                // 해당 노드를 찾았을 때
                if (currNode.value == value) {
                    search = true;
                    break;
                }
                // 해당 노드가 현재 노드보다 작을 때 왼쪽으로 탐색
                else if (currNode.value > value) {
                    currParentNode = currNode;
                    currNode = currParentNode.left;
                }
                // 해당 노드가 현재 노드보다 작을 때 오른쪽으로 탐색
                else {
                    currParentNode = currNode;
                    currNode = currParentNode.right;
                }
            }
            if (search == false) {
                return false;
            }
        }
        // 1. 삭제하려는 노드가 Leaf Node 인 경우
        if (currNode.left == null && currNode.right == null) {
            currNode = null;
            return true;
        }
        // 2. 삭제하려는 노드가 왼쪽 노드만 존재한 경우
        else if (currNode.left == null && currNode.right != null) {
            // 현재 노드가 부모에서 오른쪽 노드에 있는 경우
            if (currParentNode.value > currNode.value) {
                currParentNode.right = currNode.right;
            }
            // 현재 노드가 부모에서 왼쪽 노드에 있는 경우
            else {
                currParentNode.left = currNode.right;
            }
            return true;
        }
        // 3. 삭제하려는 노드가 오른쪽 노드만 존재한 경우
        else if (currNode.left != null && currNode.right == null) {
            if (currParentNode.value > currNode.value) {
                currParentNode.right = currNode.left;
            }
            // 현재 노드가 부모에서 왼쪽 노드에 있는 경우
            else {
                currParentNode.left = currNode.left;
            }
            return true;
        }
        // 4. 삭제하려는 노드가 오른쪽 노드, 왼쪽 노드가 존재한 경우.
        else {
            Node changeNodeParent = currNode.right;
            Node changeNode = currNode.right;
            // 삭제할 노드의 바꿀 노드를 찾는 것.
            while (changeNode.left != null) {
                changeNodeParent = changeNode;
                changeNode = changeNode.left;
            }
            // 4-1-2. 삭제하려는 노드와 바꾸려는 노드에 오른쪽 Node가 존재하는 경우.
            if (changeNode.right != null) {
                changeNodeParent.left = changeNode.right;
            }
            // 4-1-1. 삭제하려는 노드와 바꾸려는 노드가 Leaf Node 인 경우.
            else {
                changeNodeParent.left = null;
            }
            // 4-1. 삭제하려는 노드가 부모노드의 왼쪽에 있는 경우.
            if (currNode.value < currParentNode.value) {
                currParentNode.left = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
            }
            // 4-2. 삭제하려는 노드가 부모노드의 오른쪽에 있는 경우
            else {
                currParentNode.right = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        MyTree myTree = new MyTree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);

    }
}
