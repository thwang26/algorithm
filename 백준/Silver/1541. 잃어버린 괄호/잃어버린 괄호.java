import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        String expression;
        long answer;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        e.expression = br.readLine();
        br.close();
    }

    private void logic() {
        List<String> list = parsing();
        Stack<Integer> stack = new Stack<>();
        long sum = Integer.parseInt(list.get(0));
        list.remove(0);
        boolean isMinus = false;
        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            boolean currentIsMinus = iterator.next().equals("-");
            int num = Integer.parseInt(iterator.next());

            if (!isMinus && !currentIsMinus) {
                sum += num;
            } else if (!isMinus) {
                isMinus = true;
                stack.push(num);
            } else if (!currentIsMinus) {
                stack.push(num);
            } else {
                sum -= stack.stream().mapToInt(Integer::intValue).sum();
                stack.clear();
                stack.push(num);
            }
        }

        if (!stack.isEmpty()) {
            sum -= stack.stream().mapToInt(Integer::intValue).sum();
        }

        e.answer = sum;
    }

    private List<String> parsing() {
        List<String> list = new ArrayList<>();
        int number = 0;
        for (char c : e.expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                list.add(String.valueOf(number));
                number = 0;
                list.add(String.valueOf(c));
            } else {
                number = number * 10 + Character.getNumericValue(c);
            }
        }
        list.add(String.valueOf(number));
        return list;
    }

    private void output() {
        System.out.println(e.answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}