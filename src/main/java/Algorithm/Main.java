package Algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = in.nextInt();
            for (int j = 2; j <= a; i++){
                if (a % j == 0){
                    cnt++;
                }
            }
            if ( cnt == 2 ){
                sum = sum + a;
                cnt = 0;
            } else {
                cnt = 0;
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("answer");
    }
}
