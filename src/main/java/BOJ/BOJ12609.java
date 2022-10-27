package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2609
class BOJ12609{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num1Save = num1;
        int num2Save = num2;
        List<Integer> GCF = new ArrayList<>();
        int max = num1 > num2 ? num1 : num2;
        for (int i = 1; i<=max; i++){
            if (num1 == 0 || num2 == 0){
                break;
            }
            if (num1 % i == 0 && num2 % i == 0){
                num1 = num1 / i;
                num2 = num2 / i;
                GCF.add(i);
                i = 1;
            }
        }
        int share = 1;
        for (int i = 0; i<GCF.size(); i++){
            share = share * GCF.get(i);
        }
        int LCM1 = num1Save / share;
        int LCM2 = num2Save / share;
        System.out.println(share);
        System.out.println(share * LCM1 * LCM2);
    }
}