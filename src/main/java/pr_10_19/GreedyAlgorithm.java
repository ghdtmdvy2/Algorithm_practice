package pr_10_19;

import java.util.Arrays;

public class GreedyAlgorithm {
    public void knapsackFunc(Integer[][] objectList, double capacity){
        double totalValue = 0;
        double fraction = 0;
        Arrays.sort(objectList,(o1, o2) -> (o2[1] / o2[0]) - (o1[1] / o1[0]));
        for (int i = 0; i<objectList.length; i++) {
            if (capacity / objectList[i][0] >= 1) {
                totalValue += objectList[i][1];
                capacity -= objectList[i][0];
            } else {
                fraction = capacity / objectList[i][0] ;
                totalValue += objectList[i][1] * fraction;
                break;
            }
        }
        System.out.println("총 가치 " + totalValue);

    }
    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}
