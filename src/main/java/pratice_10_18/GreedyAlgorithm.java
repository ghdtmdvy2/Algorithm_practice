package pratice_10_18;

import java.util.Arrays;

public class GreedyAlgorithm {
    public void knapsackFunc(Integer[][] objectList,double capacity){
        double totalValue = 0;
        double fraction = 0;
        Arrays.sort(objectList,(o1,o2) -> ((o2[1] / o2[0]) - (o1[1] / o1[0])));

        for (int i = 0; i<objectList.length; i++){
            if(capacity / objectList[i][0] >= 1){
                totalValue += objectList[i][1];
                capacity -= objectList[i][0];
                System.out.println("가치" + totalValue  +"무게"+objectList[i][0]+"남은 무게" + capacity);
            } else {
                fraction = capacity/objectList[i][0];
                totalValue += objectList[i][1] * fraction;
                System.out.println("총 가치 수" + totalValue + "부분 가치 수"+objectList[i][1] *fraction + "비율" + fraction);
                break;
            }
        }
    }
    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        // 무게, 가치 순으로 들어감
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}
