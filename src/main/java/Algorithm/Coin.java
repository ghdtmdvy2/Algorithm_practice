package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Coin {
    public static void solution(Integer price, ArrayList<Integer> coinList){
        Integer CoinCnt = 0;
        Integer CoinNum = 0;
        for (int i = 0; i<coinList.size(); i++){
            CoinCnt += price / coinList.get(i);
            CoinNum = price / coinList.get(i);
            price -= coinList.get(i)*CoinNum;
            System.out.println(coinList.get(i) + "원:"+ CoinNum +"개");
        }
        System.out.println("총 개수:"+CoinCnt);
    }
    public static void main(String[] args) {
        Coin.solution(4720,new ArrayList<>(Arrays.asList(500,100,50,1)));
    }
}
