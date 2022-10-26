package BOJ;

import java.util.*;
// https://www.acmicpc.net/problem/1260
class BOJ1260{
    public static ArrayList<Integer> searhDFS(HashMap<Integer,ArrayList<Integer>> graph, Integer startNode){
        ArrayList<Integer> visitedNode = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        visitedNode.add(startNode);
        ArrayList<Integer> adjacentNode = graph.get(startNode);
        if (adjacentNode != null){
            Collections.sort(adjacentNode,Collections.reverseOrder());
            stack.addAll(adjacentNode);
        }
        while(stack.size() > 0){
            Integer node = stack.pop();
            if (!visitedNode.contains(node)){
                visitedNode.add(node);
                if (graph.get(node) != null){
                    adjacentNode = graph.get(node);
                    Collections.sort(adjacentNode,Collections.reverseOrder());
                    stack.addAll(graph.get(node));
                }
            }
        }
        return visitedNode;
    }
    public static ArrayList<Integer> searhBFS(HashMap<Integer,ArrayList<Integer>> graph, Integer startNode){
        ArrayList<Integer> visitedNode = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        visitedNode.add(startNode);
        ArrayList<Integer> adjacentNode = graph.get(startNode);
        if (adjacentNode != null) {
            Collections.sort(adjacentNode);
            queue.addAll(adjacentNode);
        }
        while(queue.size() > 0){
            Integer node = queue.poll();
            if (!visitedNode.contains(node)){
                visitedNode.add(node);
                if (graph.get(node) != null){
                    adjacentNode = graph.get(node);
                    Collections.sort(adjacentNode);
                    queue.addAll(adjacentNode);
                }
            }
        }
        return visitedNode;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i<M; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (graph.get(num1) == null && graph.get(num2) == null ){
                graph.put(num1,new ArrayList<>(Arrays.asList(num2)));
                graph.put(num2,new ArrayList<>(Arrays.asList(num1)));
            }
            else if (graph.get(num2) == null ){
                graph.put(num2,new ArrayList<>(Arrays.asList(num1)));
                graph.get(num1).add(num2);
            }
            else if (graph.get(num1) == null ){
                graph.put(num1,new ArrayList<>(Arrays.asList(num2)));
                graph.get(num2).add(num1);
            } else {
                graph.get(num1).add(num2);
                graph.get(num2).add(num1);
            }
        }
        ArrayList<Integer> arrayList1 = searhDFS(graph, V);
        ArrayList<Integer> arrayList2 = searhBFS(graph, V);
        for(int i = 0; i< arrayList1.size(); i++){
            System.out.print(arrayList1.get(i)+" ");
        }
        System.out.println();
        for(int i = 0; i< arrayList2.size(); i++){
            System.out.print(arrayList2.get(i)+" ");
        }
    }
}