package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch_2 {
    public static boolean searchItem(int[] testData, int searchItem){
        if (testData.length == 1 && testData[0] == searchItem){
            return true;
        }
        if (testData.length == 1 && testData[0] != searchItem){
            return false;
        }
        if (testData.length < 0) {
            return false;
        }
        int index = testData.length / 2;
        if (testData[index] == searchItem) {
            return true;
        }else {
            if (testData[index] > searchItem) {
                return searchItem(Arrays.copyOfRange(testData,0,index),searchItem);
            } else {
                return searchItem(Arrays.copyOfRange(testData,index+1,testData.length),searchItem);
            }
        }
    }
    public static void main(String[] args) {
        int[] testData = new int[100];

        for (int index = 0; index < 100; index++) {
            testData[index] =(int)(Math.random() * 100);
        }
        Arrays.sort(testData);
        for (int index = 0; index < 100; index++) {
            System.out.print(testData[index] + " \n");
        }
        System.out.println(searchItem(testData,95));
    }
}
