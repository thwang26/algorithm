import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static List<String> low = List.of("-", "+");
    static List<String> high = List.of("*", "/");
    static List<String> bracket = List.of("(", ")");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        StringBuilder post = new StringBuilder();
        Stack<String> sign = new Stack<>();
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            if (!isSign(current)) {
                post.append(c);
                continue;
            }

            if (current.equals("(")) {
                sign.push(current);
                continue;
            }

            if (current.equals(")")) {
                while (!sign.peek().equals("(")) {
                    post.append(sign.pop());
                }
                sign.pop();
                continue;
            }

            if (!sign.isEmpty() && hasHighLevel(sign.peek(), current)) {
                while (!sign.isEmpty() && hasHighLevel(sign.peek(), current)) {
                    post.append(sign.pop());
                }
                sign.push(current);
            } else {
                sign.push(current);
            }
        }

        while (!sign.isEmpty()) {
            post.append(sign.pop());
        }

        System.out.println(post);
    }

    public static boolean isSign(String current) {
        return low.contains(current) || high.contains(current) || bracket.contains(current);
    }

    public static boolean hasHighLevel(String peek, String current) {
        if (bracket.contains(peek)) {
            return false;
        }

        if (low.contains(current)) {
            return true;
        } else {
            return high.contains(peek);
        }
    }
}
