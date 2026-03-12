import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < dice.length; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, dice[i]);
        }

        long a = Math.min(dice[0], dice[5]);
        long b = Math.min(dice[1], dice[4]);
        long c = Math.min(dice[2], dice[3]);

        long[] arr = new long[]{a, b, c};

        Arrays.sort(arr);

        long[] ans = new long[3];
        if (n > 2) {
            ans[0] = ((long) Math.pow(n, 2) * 5) - (16L * n) + 12;
        }

        if (n > 1) {
            ans[1] = (8L * n) - 12;
        }

        if (n == 1) {
            ans[2] = 5;
        } else {
            ans[2] = 12;
        }

        ans[0] *= arr[0];
        ans[1] = arr[0] * ans[1] + arr[1] * ans[1];
        if (n == 1) {
            ans[2] = Arrays.stream(dice).sum() - max;
        } else {
            ans[2] = 4L * arr[0] + 4L * arr[1] + 4L * arr[2];
        }
        System.out.println(ans[0] + ans[1] + ans[2]);
    }
}
/*
총 면의 개수 - 5n^2
한개만 보이는 면 - 5n^2 - 16n + 12
두개만 보이는 면 - 8n - 12
세 개 보이는 면 - 12개로 상수 고정

n = 1
총 면의 개수 - 5
한면 - 0
두면 - 0
세면이상 - 5

n = 2
총 면의 개수 - 20
한면 - 0
두면 - 8
세면 - 12

n = 3
총 면의 개수 - 45
한면 - 9
두면 - 24
세면 - 12

n = 4
총 면의 개수 - 80
한면 - 28
두면 - 40
세면 - 12
 */