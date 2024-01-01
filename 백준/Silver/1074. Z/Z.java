import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Main main = new Main();
    Element e = new Element();

    static class Element {
        int n;
        int r;
        int c;
        int answer;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        e.n = Integer.parseInt(st.nextToken());
        e.r = Integer.parseInt(st.nextToken());
        e.c = Integer.parseInt(st.nextToken());
    }

    private void logic() {
        dfs((int)Math.pow(2, e.n)/2, 0, (int)Math.pow(2, e.n * 2), e.r, e.c);
    }

    private void dfs(int n, int min, int max, int row, int col) {
        if (max - min == 1) {
            e.answer = min;
            return;
        }

        int gap = max - min;
        if (row < n && col < n) { // 2사
            dfs(n/2, min, min + gap/4, row, col);
        } else if (row >= n && col < n) { // 3사
            dfs(n/2, min + gap/2, min + gap/4 * 3, row - n, col);
        } else if (row < n && col >= n) { // 1사
            dfs(n/2, min + gap/4, min + gap/4 * 2, row, col - n);
        } else { // 4사
            dfs(n/2, min + gap/4 * 3, max, row - n, col - n);
        }
    }

    private void output() {
        System.out.println(e.answer);
    }

    public static void main(String[] args) throws IOException {
        main.input();
        main.logic();
        main.output();
    }
}
