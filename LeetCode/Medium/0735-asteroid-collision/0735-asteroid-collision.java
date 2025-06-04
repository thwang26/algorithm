import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int each : asteroids) {
            boolean broken = false;
            while (!broken && !stack.isEmpty() && canExplode(stack.peek(), each)) {
                int peek = Math.abs(stack.peek());
                int current = Math.abs(each);
                if (peek > current) {
                    broken = true;
                }
                if (peek == current) {
                    stack.pop();
                    broken = true;
                }
                if (peek < current) {
                    stack.pop();
                }
            }

            if (!broken) {
                stack.push(each);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean canExplode(int a, int b) {
        return a > 0 && b < 0;
    }
}
