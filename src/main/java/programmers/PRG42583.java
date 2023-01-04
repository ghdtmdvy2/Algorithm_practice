package programmers;

import java.util.LinkedList;
import java.util.Queue;
// https://school.programmers.co.kr/learn/courses/30/lessons/42583
public class PRG42583 {
    class Truck {
        int value;
        int time;
        Truck(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int time = 1;
        Queue<Truck> queue = new LinkedList<>();
        queue.add(new Truck(truck_weights[0],1));
        int topWeight = truck_weights[0];
        int topCnt = 1;
        int index = 1;
        while(!(queue.isEmpty())){
            Truck truck = queue.peek();
            // 다리를 지나는 경우 (시간이 2초 인 경우)
            if (truck.time == bridge_length) {
                topWeight = topWeight - truck.value;
                topCnt = topCnt - 1;
                queue.remove();
            }

            // 다리에 있는 트럭은 1초 갱신
            int size = queue.size();
            for (int i = 0; i<size; i++){
                Truck bridge_tru = queue.remove();

                bridge_tru.time++;
                queue.add(bridge_tru);
            }


            // 다리를 건널 수 있을 경우
            if (index < truck_weights.length && topWeight + truck_weights[index] <= weight && topCnt + 1 <= bridge_length) {
                topWeight = topWeight + truck_weights[index];
                topCnt = topCnt + 1;
                queue.add(new Truck(truck_weights[index],1));
                index++;
            }
            answer++;
        }
        return answer;
    }
}
