import java.util.Scanner;

public class Main {
    static char[] str;
    static int strIdx;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next().toCharArray();
        n = 0;
        while (strIdx < str.length) {
            n++;
            findIdx();
        }
        System.out.println(n);
    }

    private static void findIdx() {
        char[] number = String.valueOf(n).toCharArray();
        int numberIdx = 0;
        while (numberIdx < number.length && strIdx < str.length) {
            if (number[numberIdx] == str[strIdx]) {
                strIdx++;
            }
            numberIdx++;
        }
    }
}