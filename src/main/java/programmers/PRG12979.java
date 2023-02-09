package programmers;

public class PRG12979 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int spreadPlace = w * 2 + 1;
        int j = 0;
        for (int i = 1; i<=n;){
            if (j >= stations.length) {
                int needStation = n - i + 1;
                int station = needStation/ spreadPlace;
                int spread = needStation % spreadPlace;
                if (spread > 0) {
                    station++;
                }
                answer += station;
                break;
            } else {
                int needStation = stations[j] - w - i;
                int station = needStation/ spreadPlace;
                int spread = needStation % spreadPlace;
                if (spread > 0) {
                    station++;
                }
                answer += station;
                i = stations[j] + w + 1;
                j++;
            }
        }
        return answer;
    }
}
