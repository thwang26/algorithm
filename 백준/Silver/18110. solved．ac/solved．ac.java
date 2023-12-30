import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static Main main = new Main();
    Element e = new Element();

    static class Element {
        int n;
        int[] arr;
        int answer;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        e.n = Integer.parseInt(br.readLine());

        e.arr = new int[e.n];
        for (int i = 0; i < e.n; i++) {
            e.arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private void logic() {
        if (e.n == 0) {
            e.answer = 0;
            return;
        }

        int round = (int) Math.round(e.n * 15 / (double) 100);
        Arrays.sort(e.arr);

        e.answer = (int) Math.round(Arrays.stream(e.arr, round, e.n - round)
                .average().getAsDouble());
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
