import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.isEmpty()) {
                    stack.add(new Top(height, i));
                    bw.write(0 + " ");
                    break;
                }

                Top peek = stack.peek();
                if (peek.height > height) {
                    stack.add(new Top(height, i));
                    bw.write(peek.index + " ");
                    break;
                }

                if (peek.height <= height) {
                    stack.pop();
                }
            }
        }

        bw.flush();
    }

    static class Top {
        int height;
        int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
