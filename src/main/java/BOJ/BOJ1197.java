package BOJ;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/1197
public class BOJ1197 {
    static HashMap<Long, Long> parent = new HashMap<>();
    static HashMap<Long, Long> rank = new HashMap<>();
    public static class Edge implements Comparable<Edge>{
        Long vertex1;
        Long vertex2;
        Long distance;
        Edge( Long distance,Long vertex1,Long vertex2){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.distance = distance;
        }
        @Override
        public int compareTo(Edge o){
            return (int)(this.distance - o.distance);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex1='" + vertex1 + '\'' +
                    ", vertex2='" + vertex2 + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }
    public static void makeSet(Long node){
        parent.put(node,node);
        rank.put(node,0L);
    }

    public static Long find(Long node){
        if (parent.get(node) != node){
            parent.put(node,find(parent.get(node)));
        }
        return parent.get(node);
    }
    public static void union(Long vertex1, Long vertex2){
        Long root1 = find(vertex1);
        Long root2 = find(vertex2);
        if (rank.get(root1) < rank.get(root2)){
            parent.put(root1,root2);
        } else {
            parent.put(root2,root1);
            if (rank.get(root1) == rank.get(root2)){
                rank.put(root1,rank.get(root1) + 1);
            }
        }
    }
    public static long KruskalFuc(Set<Long> vertices, ArrayList<Edge> edges, long mstVertex){
        long answer = 0;
        int c = 0;
        Iterator<Long> iterSet = vertices.iterator();
        while(iterSet.hasNext()){
            makeSet(iterSet.next());
        }

        Collections.sort(edges);
        for (int i = 0; i<edges.size(); i++){
            Edge edge = edges.get(i);
            if (find(edge.vertex1) != find(edge.vertex2)){
                union(edge.vertex1,edge.vertex2);
                c++;
                answer = answer + edge.distance;
                if (mstVertex-1 == c){
                    return answer;
                }

            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Set<Long> vertices = new HashSet<>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long V = Long.parseLong(st.nextToken());
        long E = Long.parseLong(st.nextToken());
        for (long i = 1; i<=V; i++){
            vertices.add(i);
        }
        for (int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());


            long vertex1 = Long.parseLong(st.nextToken());
            long vertex2 = Long.parseLong(st.nextToken());
            long distance = Long.parseLong(st.nextToken());
            if (vertex1 <= V || vertex2 <= V ){
                edges.add(new Edge(distance,vertex1,vertex2));
                vertices.add(vertex1);
                vertices.add(vertex2);
            }
        }

        long answer = KruskalFuc(vertices, edges, V);

        System.out.println(answer);
    }
}
