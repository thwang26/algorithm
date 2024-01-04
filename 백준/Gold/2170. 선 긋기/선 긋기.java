import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        List<int[]> list = new ArrayList<>();
        long answer;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
            e.list.add(arr);
        }
        br.close();
    }

    private void logic() {
        e.list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int[] pivot = e.list.get(0);
        long count = pivot[1] - pivot[0];
        for (int i = 1; i < e.list.size(); i++) {
            int[] current = e.list.get(i);
            if (current[1] <= pivot[1]) {
                continue;
            }
            if (current[0] < pivot[1]) {
                count += current[1] - pivot[1];
            } else {
                count += current[1] - current[0];
            }
            pivot = current;
        }
        e.answer = count;
    }

    private void output() {
        System.out.println(e.answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}
