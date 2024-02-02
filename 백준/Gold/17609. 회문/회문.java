import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while (n-- > 0) {
            String str = sc.next();

            if (checkPalindrome(str)) {
                System.out.println(0);
                continue;
            }
            if (checkSemiPalindrome(str)) {
                System.out.println(1);
                continue;
            }
            System.out.println(2);
        }
    }

    private static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean checkSemiPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return checkPalindrome(str.substring(left + 1, right + 1))
                        || checkPalindrome(str.substring(left, right));
            }

            left++;
            right--;
        }

        return true;
    }
}
