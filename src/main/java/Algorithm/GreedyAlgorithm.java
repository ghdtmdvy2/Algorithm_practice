package Algorithm;

import java.util.Arrays;

public class GreedyAlgorithm {
    // objectList 무게와 가치를 지닌 물건
    // capacity 무게 제한
    public static void knapsackFunc(Integer[][] objectList, double capacity){
        // 총 가치 수
        double totalValue = 0;
        // 무게 제한 만큼 들어가지 못할 때 부분만 들어갈 수 있게 만듦.
        // 예를 들어 총 무게 제한이 30인데 25 짜리 무게가 들어가야하는 경우.
        double fraction = 0;

        // 정렬 기준을 (가치/무게)[가치가 높은것을 뜻함]를 해주어 내림차순 정렬
        Arrays.sort(objectList, (o1, o2) -> (o2[1] / o2[0] - o1[1] / o1[0]));

        for (int i = 0; i <objectList.length; i++){
            // 1. 무게를 분할하여 넣지 않고, 그냥 넣을 경우
            // (총 무게 제한 / 들어갈 무게)를 해주어 몫이 0보다 크면 넣을 수 있다는 것임.
            if (capacity / objectList[i][0] > 1){
                // 가치를 넣어줌
                totalValue += objectList[i][1];
                // 넣었기 때문에 남은 용량을 구해줌
                capacity -= objectList[i][0];
                System.out.println("무게 = " + objectList[i][0] + " 가치 = " + objectList[i][1]);
            }
            // 2. 무게를 분할하여 넣는 경우
            else {
                // (무게/가치)를 해주어 1 무게당 가치가 얼만큼 들어가는 지 알려줌
                // 남은 용량을 곱해주어 가치를 저장
                fraction = capacity / objectList[i][0];
                totalValue += objectList[i][1] * fraction;

                System.out.println("무게 = " + objectList[i][0] + " 가치 = " + objectList[i][1] + " 비율 = " + fraction);
                break;
            }
        }
        System.out.println("총 가치 수 = "+totalValue);
    }

    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}
