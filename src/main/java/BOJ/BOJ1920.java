package BOJ;

//https://www.acmicpc.net/problem/1920
import java.util.*;

class BOJ1920{
    public static int binarySearch(List<Integer> arrayList, int searchItem){
        if(arrayList.size() == 1 && arrayList.get(0) == searchItem){
            return 1;
        }
        if (arrayList.size() == 1 && arrayList.get(0) != searchItem){
            return 0;
        }
        if (arrayList.size() == 0){
            return 0;
        }
        int midSize = arrayList.size() / 2;
        if (arrayList.get(midSize) == searchItem){
            return 1;
        }
        if (arrayList.get(midSize) > searchItem){
            return binarySearch(arrayList.subList(0,midSize), searchItem);
        } else {
            return binarySearch(arrayList.subList(midSize,arrayList.size()),searchItem);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i<N; i++){
            list1.add(sc.nextInt());
        }
        N = sc.nextInt();
        Collections.sort(list1);

        for (int i = 0; i<N; i++){
            System.out.println(binarySearch(list1,sc.nextInt()));
        }
    }
}