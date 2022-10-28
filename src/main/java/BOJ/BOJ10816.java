package BOJ;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/10816
class BOJ10816 {
    public static int BinarySearch(List<Integer> list, Integer searchItem){
        if (list.size() == 1 && list.get(0) == searchItem){
            list.remove(0);
            return 1;
        }
        if (list.size() == 1 && list.get(0) != searchItem){
            return 0;
        }
        if (list.size() == 0){
            return 0;
        }
        int midSize = list.size() / 2;
        if (list.get(midSize) == searchItem){
            list.remove(midSize);
            return 1;
        }
        if (list.get(midSize) > searchItem){
            return BinarySearch(list.subList(0,midSize),searchItem);
        } else {
            return BinarySearch(list.subList(midSize,list.size()),searchItem);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i<N; i++){
            cards.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(cards);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> answers = new HashMap<>();
        int findCheck = 1;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<M; i++){
            int searchItem = Integer.parseInt(st.nextToken());
            list.add(searchItem);
            while (findCheck == 1){
                findCheck = BinarySearch(cards,searchItem);
                if (findCheck == 0){
                    break;
                } else {
                    cnt++;
                }
            }
            if ( answers.get(searchItem) == null) {
                answers.put(searchItem,cnt);
            }
            cnt = 0;
            findCheck = 1;
        }
        for (int i = 0; i<list.size(); i++){
            if (i == list.size() - 1){
                System.out.print(answers.get(list.get(i)));
            } else {
                System.out.print(answers.get(list.get(i)) + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}