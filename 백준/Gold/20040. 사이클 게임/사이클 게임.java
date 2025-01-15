import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int turn = 0;
        boolean isCycle = false;
        while (m-- > 0) {
            ++turn;
            int start = sc.nextInt();
            int to = sc.nextInt();
            isCycle = union(start, to);
            if (isCycle) {
                break;
            }
        }

        System.out.println(isCycle ? turn : 0);
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    } // 루트 노드를 찾음

    private static boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);
        if (a != b) {
            arr[a] = b;
            return false;
        }
        return true;
    } // 루트 노드가 서로 다르면 연결해줌
}
