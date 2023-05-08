import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();
        for (char c : arr) {
            if (c >= 'a' && c <= 'z') {
                c = (char)((int)c - 'a' + 'A');
            } else {
                c = (char)((int)c - 'A' + 'a');
            }
            System.out.print(c);
        }
    }
}