package Algorithm;

public class fibonacci {
    public static Integer fibo(Integer data){
        if (data > 1){
            return fibo(data-1) + fibo(data-2);
        }
        else if (data == 1){
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(fibo(9));
    }
}
