package PCCP;

import java.util.LinkedList;
import java.util.Queue;

public class PCCP_2_4 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] jx = {-2,0,2,0,-1,-1,1,1};
    // static int[] jx = {-2,0,2,0};
    static int[] jy = {0,2,0,-2,-1,1,1,-1};
    // static int[] jy = {0,2,0,-2};
    static int[][][] visited;
    static int[][] miro;
    public static int bfs(int x, int y, int mCnt, int jChk) {
        visited[jChk][x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,mCnt,jChk});
        while(!queue.isEmpty()){
            int[] c = queue.remove();
            int cx = c[0];
            int cy = c[1];
            int cmCnt = c[2];
            int cjChk = c[3];
            if (cx == miro.length - 1 && cy == miro[0].length - 1) {
                return cmCnt;
            }
            for (int i = 0; i<4; i++){
                int vx = dx[i] + cx;
                int vy = dy[i] + cy;
                if (vx <= 0 || vy <= 0 || vx >= miro.length || vy >= miro[0].length) {
                    continue;
                }
                if (visited[cjChk][vx][vy] == 0 && miro[vx][vy] != 1) {
                    visited[cjChk][vx][vy] = 1;
                    queue.add(new int[]{vx,vy,cmCnt + 1, cjChk});
                }
            }
            if (cjChk == 0) {
                for (int i = 0; i<8; i++){
                    int vx = jx[i] + cx;
                    int vy = jy[i] + cy;
                    if (vx <= 0 || vy <= 0 || vx >= miro.length || vy >= miro[0].length) {
                        continue;
                    }
                    if (visited[1][vx][vy] == 0 && miro[vx][vy] != 1) {
                        visited[1][vx][vy] = 1;
                        queue.add(new int[]{vx,vy,cmCnt + 1, cjChk + 1});
                    }
                }
            }
        }
        return -1;
    }
    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        visited = new int[2][n+1][m+1];
        miro = new int[n+1][m+1];
        for (int i = 0; i<hole.length; i++){
            int x = hole[i][0];
            int y = hole[i][1];
            miro[x][y] = 1;
        }
        answer = bfs(1,1,0,0);
        return answer;
    }
}
