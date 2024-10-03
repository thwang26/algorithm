import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PasswordChecker checker = new PasswordChecker();
        while (true) {
            String password = sc.next();

            if ("end".equals(password)) {
                break;
            }

            checker.addPassword(password);
        }

        checker.check();
    }

    static class PasswordChecker {
        String vowels = "aeiou";
        List<String> password = new ArrayList<>();

        public void addPassword(String password) {
            this.password.add(password);
        }

        public void check() {
            for (String each : password) {
                if (checkVowels(each) && checkTriple(each) && checkDual(each)) {
                    System.out.printf("<%s> is acceptable.", each);
                } else {
                    System.out.printf("<%s> is not acceptable.", each);
                }
                System.out.println();
            }
        }

        private boolean checkVowels(String str) {
            for (char c : str.toCharArray()) {
                if (vowels.contains(String.valueOf(c))) {
                    return true;
                }
            }

            return false;
        }

        private boolean checkTriple(String str) {
            for (int i = 2; i < str.length(); i++) {
                String secondBefore = String.valueOf(str.charAt(i - 2));
                String before = String.valueOf(str.charAt(i - 1));
                String current = String.valueOf(str.charAt(i));

                if (vowels.contains(secondBefore) && vowels.contains(before) && vowels.contains(current)) {
                    return false;
                } else if (!vowels.contains(secondBefore) && !vowels.contains(before) && !vowels.contains(current)) {
                    return false;
                }
            }

            return true;
        }

        private boolean checkDual(String str) {
            for (int i = 1; i < str.length(); i++) {
                String before = String.valueOf(str.charAt(i - 1));
                String current = String.valueOf(str.charAt(i));

                if (before.equals(current) && !(before + current).equals("ee")
                        && !(before + current).equals("oo")) {
                    return false;
                }
            }

            return true;
        }
    }
}
