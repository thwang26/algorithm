import java.util.*;

class Node {
    Node next;
    boolean isDeleted;
    int num;

    public Node(Node next, boolean isDeleted, int num) {
        this.next = next;
        this.isDeleted = isDeleted;
        this.num = num;
    }
}

class LinkedList {
    Node head;

    public void add(int num) {
        if (this.head == null) {
            this.head = new Node(null, false, num);
            this.head.next = this.head;
        } else {
            Node cur = this.head;
            while (cur.next != this.head) {
                cur = cur.next;
            }
            cur.next = new Node(this.head, false, num);
        }
    }

    public int size() {
        int size = 1;
        Node cur = this.head;

        if (this.head == null) {
            return 0;
        }

        while (cur.next != this.head) {
            cur = cur.next;
            size++;
        }
        return size;
    }
}
public class Main {
    public static void solution(int n, int k) {
        LinkedList list = new LinkedList();
        int cnt = 1; // 어느 지점에서 출력할 지 알기위해
        int printCnt = 0; // 얼마나 출력했는지 알기위해
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        Node cur = list.head;
        sb.append("<");
        while(printCnt != n){
            if (cnt % k == 0 && !cur.isDeleted) {
                sb.append(cur.num);
                cur.isDeleted = true; // 출력 된 노드인지 알기위해
                printCnt++;
                if (printCnt == n){
                    sb.append(">");
                } else {
                    sb.append(", ");
                }
            }
            cur = cur.next;
            if (!cur.isDeleted) {
                cnt++;
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        solution(n, k);
    }
}