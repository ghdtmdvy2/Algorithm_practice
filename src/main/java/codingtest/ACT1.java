package codingtest;

public class ACT1 {
    static String processed = "";
    static String removed = "";
    static int result = 0;
    public static void removeChar(String s, int n){
        StringBuilder sb = new StringBuilder(s);
        // n번째로 지정된 값이 문자열보다 큰 경우 return -1
        if (sb.length() < n) {
            result = -1;
            return;
        }
        // 문자열의 값이 null 인 경우에는 -2
        if (sb == null || sb.length() == 0){
            result = -2;
            return;
        }
        int cnt = 1;
        for (int i = 0; i<sb.length(); i++){
            // n이 0일 때는 0번째만 삭제해주고 리턴
            if (n == 0) {
                sb.deleteCharAt(0);
                return;
            }
            // n번째에 해당하는 경우 n으로 바꾸기.
            else if (i != 0 && cnt % n == 0) {
                removed += sb.charAt(i);
                sb.setCharAt(i, 'n');
            }
            cnt++;
        }
        for (int i = 0; i<sb.length(); i++){
            // n번째 해당하는 것이 있으면 삭제.
            if (sb.charAt(i) == 'n'){
                sb.deleteCharAt(i);
            }
        }
        processed = String.valueOf(sb);
        return;
    }

    public static void main(String[] args) {
        removeChar("123456789",3);
    }
}
