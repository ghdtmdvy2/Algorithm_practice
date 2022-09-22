package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Edge_sort_Comparable {
    Integer distance;
    String vertex;

    Edge_sort_Comparable(Integer distance, String vertex){
        this.distance = distance;
        this.vertex = vertex;
    }
    public static void main(String[] args) {
        Edge_sort_Comparable edge1 = new Edge_sort_Comparable(13,"A");
        Edge_sort_Comparable edge2 = new Edge_sort_Comparable(10,"A");
        Edge_sort_Comparable edge3 = new Edge_sort_Comparable(12,"A");
        Edge_sort_Comparable[] Edge = new Edge_sort_Comparable[]{edge1,edge2,edge3};
        // Edge에 대한 정렬을 시도하자 distance와 vertex 중 어떤 것이 정렬 기준인지 몰라 Exception 에러가 뜸.
        // 그래서 정렬 기준을 정하고자 두가지 방법이 있음 Comparator, Comparable
        // 1. Comparable 클래스 안에 interface 를 정의하여 오버라이드 하는 경우.
        // 2. Comparator Arrays.sort 메서드에서 두 번째 파라미터로 객체 생성하여 오버라이드 하는 경우.
        Arrays.sort(Edge, (o1, o2) -> o1.distance - o2.distance);
        for (int i = 0; i<Edge.length; i++){
            System.out.println(Edge[i].distance);
        }
    }
}
