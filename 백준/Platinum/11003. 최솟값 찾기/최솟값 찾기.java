import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Number> deque = new LinkedList<>();

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            Number number = new Number(Integer.parseInt(st.nextToken()),
                    idx++);

            while (!deque.isEmpty() && number.n < deque.peekLast().n) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst().idx < idx - l) {
                deque.pollFirst();
            }

            deque.addLast(number);
            bw.write(deque.peekFirst().n + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static class Number {
        int n;
        int idx;

        public Number(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
}
