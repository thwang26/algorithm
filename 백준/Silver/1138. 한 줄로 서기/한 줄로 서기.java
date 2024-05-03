import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            answer.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int each : answer) {
            sb.append(each).append(" ");
        }

        System.out.println(sb);
    }
}
