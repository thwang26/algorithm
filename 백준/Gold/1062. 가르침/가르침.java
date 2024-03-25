import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int maxWord = 0;
    static int n;
    static int k;
    static boolean[] visited = new boolean[26];
    static List<String> mark = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        mark = new ArrayList<>();
        while (n-- > 0) {
            String current = sc.next();
            mark.add(current.substring(4, current.length() - 4));
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        backTrack(0, 0);
        System.out.println(maxWord);
    }

    private static void backTrack(int idx, int length) {
        if (length + 5 == k) {
            check();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTrack(i + 1, length + 1);
                visited[i] = false;
            }
        }
    }
    
    private static void check() {
        int count = 0;
        for (String each : mark) {
            if (contains(each, visited)) {
                count++;
            }
        }
        maxWord = Math.max(maxWord, count);
    }

    private static boolean contains(String word, boolean[] arr) {
        for (char each : word.toCharArray()) {
            if (!arr[each - 'a']) {
                return false;
            }
        }

        return true;
    }
}
