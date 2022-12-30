package PCCP;

import java.util.LinkedList;
import java.util.Queue;

public class PCCP_2_4 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] jx = {-2,0,2,0};
    static int[] jy = {0,2,0,-2};
    static int[][][] visited;
    static int[][][] miro;
    public static void dfs(int n, int m,int[][] hole){
        visited[0][0][0] = 1;
        visited[1][0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        outerLoop:
        while(!queue.isEmpty()){
            int current[] = queue.remove();
            int item = current[0];
            int cx = current[1];
            int cy = current[2];
            for (int i = 0; i<4; i++){

                int vx = cx + dx[i];
                int vy = cy + dy[i];
                if (vx < 0 || vy < 0 || vx >= n || vy >= m) {
                    continue;
                }
                // 나의 문제점 : 아이템을 썼을 때의 방문한 횟수가 그냥 뒤 늦게 온 방문한 횟수가 겹쳐지는 문제점이 생김
                // 해결상황 : 미로를 두 개를 만들어서 아이템을 쓴 miro 랑 아이템을 안 쓴 miro 를 구별.

                // 함정이 있으면서 아이템을 안 쓴 경우.
                if (miro[0][vx][vy] == -1 && item == 0) {
                    int jumpX = cx + jx[i];
                    int jumpY = cy + jy[i];
                    if (jumpX < 0 || jumpY < 0 || jumpX >= n || jumpY >= m) {
                        continue;
                    }
                    if (visited[1][jumpX][jumpY] == 0 && !(miro[1][jumpX][jumpY] == -1)) {
                        visited[1][jumpX][jumpY] = 1;
                        miro[1][jumpX][jumpY] = miro[0][cx][cy] + 1;
                        if (jumpX == n-1 && jumpY == m-1) {
                            break outerLoop;
                        }
                        queue.add(new int[]{1,jumpX,jumpY});
                    }
                }
                // 함정이 없는 경우.
                else {
                    int jumpX = cx + jx[i];
                    int jumpY = cy + jy[i];

                    // 함정이 계속 만나지 않아서 도착지에 아이템을 써서 도착하는 경우.
                    if (item == 0 && cx + jx[i] == n-1 && cy + jy[i] == n-1){
                        if (jumpX < 0 || jumpY < 0 || jumpX >= n || jumpY >= m) {
                            continue;
                        }
                        visited[item][cx + jx[i]][cy + jy[i]] = 1;
                        miro[1][cx + jx[i]][cy + jy[i]] = miro[0][cx][cy] + 1;
                        break outerLoop;
                    }
                    // 아이템을 쓰지 않은 사람.
                    else if (item == 0 && !(miro[0][vx][vy] == -1) && visited[0][vx][vy] == 0) {
                        visited[item][vx][vy] = 1;
                        miro[0][vx][vy] = miro[0][cx][cy] + 1;
                        if (vx == n-1 && vy == m-1) {
                            break outerLoop;
                        }
                        queue.add(new int[]{item,vx,vy});
                    }
                    // 아이템을 쓴 사람.
                    else if (item == 1 && !(miro[1][vx][vy] == -1) && visited[1][vx][vy] == 0) {
                        visited[item][vx][vy] = 1;
                        miro[1][vx][vy] = miro[1][cx][cy] + 1;
                        if (vx == n-1 && vy == m-1) {
                            break outerLoop;
                        }
                        queue.add(new int[]{item,vx,vy});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int answer = 0;
//        int hole[][] = {{2,3},{3,3},{4,3}};
        int hole[][] = {{1,4},{2,1},{2,2},{2,3},{2,4},{3,3},{4,1},{4,3},{5,3}};

        miro = new int[2][n][m];
        visited = new int[2][n][m];
        for (int i = 0; i<hole.length; i++){
            int x = hole[i][0];
            int y = hole[i][1];
            miro[0][x-1][y-1] = -1;
            miro[1][x-1][y-1] = -1;
        }
        dfs(n,m,hole);
        if (miro[0][n-1][m-1] == 0 && miro[1][n-1][m-1] == 0) {
            answer = -1;
        } else {
            if (miro[0][n-1][m-1] > miro[1][n-1][m-1]) {
                answer = miro[1][n-1][m-1];
            } else {
                answer = miro[0][n-1][m-1];
            }

        }
        System.out.println(answer);
    }
}
