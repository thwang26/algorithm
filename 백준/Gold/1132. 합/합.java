import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] arr = new long[10];
        boolean[] first = new boolean[10];
        while (n-- > 0) {
            String str = sc.next();
            long digit = 1;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                if (i == 0) {
                    first[c - (int) 'A'] = true;
                }
                arr[c - (int) 'A'] += digit;
                digit *= 10;
            }
        }

        boolean passFindZero = false;
        for (int i = 0; i < 10; i++) {
            if (arr[i] == 0) {
                passFindZero = true;
                break;
            }
        }

        if (!passFindZero) {
            long min = Long.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!first[i] && arr[i] < min) {
                    min = arr[i];
                    idx = i;
                }
            }
            arr[idx] = 0;
        }

        Arrays.sort(arr);

        long answer = 0;
        for (int i = 1; i < 10; i++) {
            answer += arr[i] * i;
        }

        System.out.println(answer);
    }
}
