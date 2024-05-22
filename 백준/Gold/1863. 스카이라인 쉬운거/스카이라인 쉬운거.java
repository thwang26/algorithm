import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int minBuilding = 0;
        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (!stack.contains(y)) {
                while (stack.peek() > y) {
                    stack.pop();
                }
                stack.add(y);
                minBuilding++;
            } else {
                while (stack.peek() != y) {
                    stack.pop();
                }
            }
        }

        System.out.println(minBuilding);
    }
}
