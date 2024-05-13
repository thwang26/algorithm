import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = {0, 0, 0, 0, 0};
            int six = n / 60;
            int ten = (n % 60) / 10;
            int one = n % 10;

            if (one > 5) {
                ten++;
                one -= 10;
            }
            if (ten > 3) {
                six++;
                ten -= 6;
            }
            if (ten < 0 && one == 5) {
                ten++;
                one -= 10;
            }

            arr[0] = six;
            arr[2 - (ten >= 0 ? 1 : 0)] = Math.abs(ten);
            arr[4 - (one >= 0 ? 1 : 0)] = Math.abs(one);

            Arrays.stream(arr).forEach(value -> sb.append(value).append(" "));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
