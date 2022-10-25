package codeup;

import java.util.Scanner;
// https://codeup.kr/problem.php?id=1099
public class CDU1099 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // 단, 맨 아래의 가장 오른쪽에 도착한 경우, 더 이상 움직일 수 없는 경우, 먹이를 찾은 경우에는

        int matrix[][] = new int[11][11];
        for(int i = 1; i<=10; i++){
            for (int j = 1; j<=10;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int rowAnt = 2;
        int columnAnt = 2;
        matrix[2][2] = 9;
        loop:
        for(int i = 1; i<=9; i++){
            for (int j = 1; j<=9;j++){
                if ((rowAnt == 9 && columnAnt == 9)){
                    matrix[rowAnt][columnAnt] = 9;
                    break loop;
                } else if((matrix[rowAnt+1][columnAnt] == 1 && matrix[rowAnt][columnAnt+1] == 1)){
                    matrix[rowAnt][columnAnt] = 9;
                    break loop;
                } else if( matrix[rowAnt][columnAnt+1] == 2){
                    matrix[rowAnt][columnAnt+1] = 9;
                    break loop;
                } else if(matrix[rowAnt][columnAnt+1] == 0) {
                    matrix[rowAnt][columnAnt + 1] = 9;
                    columnAnt++;
                }
                else if ((matrix[rowAnt+1][columnAnt] == 2)){
                    matrix[rowAnt+1][columnAnt] = 9;
                    break loop;
                }  else if (matrix[rowAnt+1][columnAnt] == 0){
                    matrix[rowAnt+1][columnAnt] = 9;
                    rowAnt++;
                }
            }
        }
        for(int i = 1; i<=10; i++){
            for (int j = 1; j<=10;j++){
                System.out.printf(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
