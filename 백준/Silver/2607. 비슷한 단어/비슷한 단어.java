import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str = sc.next();
        int count = 0;
        while (n-- > 1) {
            String current = sc.next();

            int findCount = 0;
            String temp = current;
            for (int i = 0; i < str.length(); i++) {
                int findIdx = find(str.charAt(i), temp);
                if (findIdx != -1) {
                    findCount++;
                    temp = edit(temp, findIdx);
                }
            }

            if (str.length() == current.length() && str.length() <= findCount + 1) {
                count++;
                continue;
            } // 길이가 같으면서 최소 하나만 다른경우

            if (str.length() + 1 == current.length() && str.length() <= findCount) {
                count++;
                continue;
            } // 길이가 1 크면서 같은 문자가 길이 이상인 경우

            if (str.length() == current.length() + 1 && str.length() == findCount + 1) {
                count++;
            } // 길이가 1 작으면서 같은 문자가 한 개 적은경우
        }

        System.out.println(count);
    }

    private static int find(char target, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return i;
            }
        }

        return -1;
    }

    private static String edit(String str, int idx) {
        return str.substring(0, idx) + str.substring(idx + 1);
    }
}
