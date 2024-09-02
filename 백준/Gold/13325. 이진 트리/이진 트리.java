import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] tree;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        tree = new int[(int) Math.pow(2, n + 1) - 1];
        dp = new int[(int) Math.pow(2, n + 1) - 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = dp[i] = sc.nextInt();
        }

        makePrefixSum(0);
        makeMax(0);
        System.out.println(Arrays.stream(tree).sum());
    }

    public static int makePrefixSum(int i) {
        if (i >= dp.length) {
            return 0;
        }

        return dp[i] += Math.max(makePrefixSum(2 * i + 1), makePrefixSum(2 * i + 2));
    }

    public static void makeMax(int i) {
        if (2 * i + 1 >= tree.length) {
            return;
        }

        int max = Math.max(dp[2 * i + 1], dp[2 * i + 2]);
        tree[2 * i + 1] += max - dp[2 * i + 1];
        tree[2 * i + 2] += max - dp[2 * i + 2];
        makeMax(2 * i + 1);
        makeMax(2 * i + 2);
    }
}
