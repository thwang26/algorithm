import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            String command = s[0];
            switch (command) {
                case "push":
                    q.push(Integer.parseInt(s[1]));
                    break;
                case "front":
                    sb.append(q.front());
                    sb.append("\n");
                    break;
                case "back":
                    sb.append(q.back());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size());
                    sb.append("\n");
                    break;
                case "empty":
                    sb.append(q.empty());
                    sb.append("\n");
                    break;
                case "pop":
                    sb.append(q.pop());
                    sb.append("\n");
                    break;
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static class Queue {
        Node head;
        Node tail;
        int size = 0;

        public void push(int val) {
            if (head == null) {
                head = new Node(val);
                tail = head;
            } else {
                tail.next = new Node(val);
                tail = tail.next;
            }
            size++;
        }

        public int front() {
            if (head == null) {
                return -1;
            }
            return head.val;
        }

        public int back() {
            if (head == null) {
                return -1;
            }
            return tail.val;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size() == 0 ? 1 : 0;
        }

        public int pop() {
            if (head == null) {
                return -1;
            }
            if (size() == 1) {
                tail = null;
            }
            int val = head.val;
            head = head.next;
            size--;
            return val;
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}