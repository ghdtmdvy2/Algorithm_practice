package PCCP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PCCP_2_3 {
    class Client{
        int time;
        int limitTime;
        Client(int time,int limitTime){
            this.time = time;
            this.limitTime = limitTime;
        }
    }
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int time = 1;
        Queue<Client> queue = new LinkedList<>();
        List<Client> list = new ArrayList<>();
        list.add(new Client(1,menu[order[0]]));
        int limitSec = 0;
        int index = 1;
        int cus = 1;
        for (int i = 0; i<order.length; i++){
            limitSec = limitSec + menu[order[i]];
        }
        while (limitSec >= time) {
            if(list.size() != 0){
                Client client = list.get(0);
                if (client.limitTime == client.time){
                    list.remove(0);
                    cus--;
                } else {
                    Client client_renewal = list.get(0);
                    client_renewal.time++;
                    list.set(0,client_renewal);
                }

            }
            if (index < order.length && time % k == 0) {
                list.add(new Client(1,menu[order[index]]));
                cus++;
                if (cus > answer) {
                    answer = cus;
                }
                index++;
            }
            time++;
        }
        return answer;
    }
}
