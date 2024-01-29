import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        System.out.println(find(S, T) ? 1 : 0);
    }

    private static boolean find(String s, String t) {
        if (s.length() == t.length()) {
            return s.equals(t);
        }

        if ('A' == t.charAt(t.length() - 1)) {
            return find(s, t.substring(0, t.length() - 1));
        } else {
            return find(s, reverse(t).substring(1));
        }
    }

    private static String reverse(String str) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }

        return reversedString.toString();
    }
}
// 1. 처음에 생각한 것 -> s 뒤에 A를 붙이는 재귀와 뒤집고 B를 붙이는 재귀 호출
// -> 시간초과
// 2. 중복된 문자열이 많아서 그런 것이라고 예상하여 set으로 중복된 문자열 제거
// -> 메모리 초과
// 3. s에서 붙여나가려면 두가지 케이스를 전부 고려해야 하여 시간복잡도 커짐
// -> A 붙이고 확인, B 붙이고 확인 이런식
// 차라리 t에서 문자열을 제거하는 방식은 정해져있으니까 그 방식으로
// -> 그냥 줄여나가면 되니 시간복잡도 줄어들 듯