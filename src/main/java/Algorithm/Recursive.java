package Algorithm;

import java.util.ArrayList;

public class Recursive {
    // 일반적인 재귀함수 형태 1
    public Integer Factorial1(Integer n) {
        if (n > 1) {
            return n * this.Factorial1(n - 1);
        } else {
            return 1;
        }
    }

    // 일반적인 재귀함수 형태 2
    public Integer Factorial2(Integer n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * this.Factorial2(n - 1);
        }
    }

    public int factorialFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }

        return dataList.get(0) + factorialFunc(new ArrayList<>(dataList.subList(1,dataList.size())));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(6);
        Recursive recursive = new Recursive();
        System.out.println(recursive.Factorial2(5));
        System.out.println("arrayList = " + arrayList);
        System.out.println(recursive.factorialFunc(arrayList));
        System.out.println("arrayList = " + arrayList);
    }
}
