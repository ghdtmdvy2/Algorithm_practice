package programmers;

public class PRG49994 {
    static int visited[][][] = new int[4][11][11];
    static int miro[][] = new int[11][11];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    public static int solution(String dirs) {
        int answer = 0;
        String dir[] = dirs.split("");
        int cx = 5;
        int cy = 5;
        String prevDir = "";
        for (String direction : dir) {
            int vx = 0;
            int vy = 0;
            int direct = 0;
            // 위쪽 방향
            if (direction.equals("U")) {
                vx = cx + dx[0];
                vy = cy + dy[0];
                direct = 0;
            }
            // 왼쪽 방향
            else if (direction.equals("L")) {
                vx = cx + dx[1];
                vy = cy + dy[1];
                direct = 1;
            }
            // 오른쪽 방향
            else if (direction.equals("D")) {
                vx = cx + dx[2];
                vy = cy + dy[2];
                direct = 2;
            }
            // 아래쪽 방향
            else if (direction.equals("R")) {
                vx = cx + dx[3];
                vy = cy + dy[3];
                direct = 3;
            }
            if (vx < 0 || vy < 0 || vx >= visited[0].length || vy >= visited[0][0].length) {
                continue;
            }
            if (direct >= 2) {
                visited[direct-2][cx][cy] = 1;
            } else {
                visited[direct+2][cx][cy] = 1;
            }
            if (visited[direct][vx][vy] == 0){
                visited[direct][vx][vy] = 1;
                answer++;
            }
            cx = vx;
            cy = vy;
        }
        return answer;
    }
}
