import java.io.*;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        int n;
        int[] dp;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        e.n = Integer.parseInt(br.readLine());
        br.close();
        e.dp = new int[Math.max(4, e.n + 1)];
    }

    private void logic() {
        e.dp[1] = 0;
        e.dp[2] = 1;
        e.dp[3] = 1;

        for (int i = 4; i <= e.n; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                e.dp[i] = Math.min(e.dp[i / 2] + 1, e.dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                e.dp[i] = Math.min(e.dp[i / 2] + 1, e.dp[i - 1] + 1);
            } else if (i % 3 == 0) {
                e.dp[i] = Math.min(e.dp[i / 3] + 1, e.dp[i - 1] + 1);
            } else {
                e.dp[i] = e.dp[i - 1] + 1;
            }
        }
    }

    private void output() throws IOException {
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(e.dp[e.n]));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}
