package codingtest;

public class Card {
    static double cardCnt = 54;
    public static double pickSameCard(int N){
        double percent = 1/cardCnt;
        for (int i = 0; i<N-1; i++){
            percent *= (1/cardCnt);
        }
        return percent;
    }
}
