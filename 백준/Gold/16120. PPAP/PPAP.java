import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ppap = sc.next();
        Stack<Character> stack = new Stack<>();
        for (char c : ppap.toCharArray()) {
            stack.push(c);
            removePPAP(stack);
        }

        removePPAP(stack);
        System.out.println(stack.size() == 1 && stack.pop() == 'P' ? "PPAP" :
                "NP");
    }

    public static void removePPAP(Stack<Character> stack) {
        if (stack.size() < 4) {
            return;
        }

        if (stack.get(stack.size() - 4) == 'P'
                && stack.get(stack.size() - 3) == 'P'
                && stack.get(stack.size() - 2) == 'A'
                && stack.get(stack.size() - 1) == 'P') {
            IntStream.range(0, 4).forEach(i -> stack.pop());
            stack.push('P');
        }
    }
}
