package BOJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2581
class BOJ2581 {
    public static int findDecimal(int number){
        int cnt = 0;
        for (int i = 1; i<=number; i++){
            if (number % i == 0 ) {
                cnt++;
            }
        }
        if (cnt == 2) {
            return number;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = sc.nextInt();
        int B = sc.nextInt();
        int answer = 0;
        int sum = 0;
        int check = 0;
        int min = 0;
        for(int i = A; i<=B; i++){
            int decimal = findDecimal(i);
            if (decimal != 0 && check == 0){
                check = 1;
                min = decimal;
                sum = sum + min;
            } else if (decimal != 0) {
                sum = sum + decimal;
            }
        }
        if (check == 0){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}