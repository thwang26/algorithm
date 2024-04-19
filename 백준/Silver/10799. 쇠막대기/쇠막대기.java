import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Factory factory = new Factory();
        for (char c : str.toCharArray()) {
            factory.add(c);
        }

        System.out.println(factory.cut);
    }

    static class Factory {
        int cut = 0;
        int stick = 0;
        Stack<Character> stack = new Stack<>();

        public Factory() {}

        public void add(char c) {
            if (c == '(') {
                stick++;
            } else {
                if (stack.peek() == '(') {
                    stick--;
                    cut += stick;
                } else {
                    cut++;
                    stick--;
                }
            }
            stack.add(c);
        }
    }
}
