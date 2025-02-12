import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String pattern = sc.next();
        int starIdx = getStarIdx(pattern);
        int length = pattern.length() - 1;
        String prefix = pattern.substring(0, starIdx);
        String postfix = pattern.substring(starIdx + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (length <= str.length() && str.startsWith(prefix) && str.endsWith(postfix)) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int getStarIdx(String pattern) {
        int idx = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 42) {
                idx = i;
                break;
            }
        }

        return idx;
    }
}
