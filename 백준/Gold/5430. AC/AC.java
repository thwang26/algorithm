import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static boolean isFront = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            isFront = true;
            String query = sc.next();
            int n = sc.nextInt();

            String str = sc.next();
            Deque<String> deque = new ArrayDeque<>(Arrays.asList(str.substring(1, str.length() - 1).split(",")));

            String result = parse(query, deque);
            System.out.println(result);
        }
    }

    static String parse(String query, Deque<String> deque) {
        for (int i = 0; i < query.length(); i++) {
            if (deque.isEmpty()) {
                return "error";
            }

            if (query.charAt(i) == 'R') {
                isFront = !isFront;
            }

            if (query.charAt(i) == 'D') {
                String value = "";
                if (isFront) {
                    value = deque.pollFirst();
                } else {
                    value = deque.pollLast();
                }

                if (value.isEmpty()) {
                    return "error";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            if (isFront) {
                sb.append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());
            }

            if (deque.isEmpty()) {
                break;
            }

            sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}
