import java.util.Scanner;

public class Main {
    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next();
        int start = 0;
        int end = 0;
        for (int i = 1; i <= 3; i++) {
            start = Integer.parseInt(str.substring(0, i));
            end = start;
            StringBuilder current = new StringBuilder(String.valueOf(start));
            boolean find = false;
            while (current.length() <= str.length()) {
                if (current.toString().equals(str)) {
                    find = true;
                    break;
                }

                end++;
                current.append(end);
            }

            if (find) {
                break;
            }
        }

        System.out.println(start + " " + end);
    }

}