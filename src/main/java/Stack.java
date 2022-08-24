import java.util.ArrayList;

public class Stack <T> {
    ArrayList<T> stack = new ArrayList<>();

    public T push(T val){
        stack.add(val);
        int leng = stack.size();
        return stack.get(leng-1);
    }
    public T pop(){
        if (stack.isEmpty()){
            return null;
        }
        int leng = stack.size();
        return stack.remove(leng-1);
    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        System.out.println(s.pop());
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}
