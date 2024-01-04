import java.io.*;
import java.util.*;

public class Main { // 신입사원
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        List<List<int[]>> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<int[]> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray());
            }
            list.sort(Comparator.comparingInt(o -> o[0]));
            e.list.add(list);
        }
        br.close();
    }

    private void logic() {
        for (List<int[]> list : e.list) {
            int count = 1;
            int pivot = list.get(0)[1];
            for (int i = 1; i < list.size(); i++) {
                int currentRank = list.get(i)[1];
                if (pivot > currentRank) {
                    count++;
                    pivot = currentRank;
                }
            }
            e.answer.add(count);
        }
    }

    private void output() {
        for (int answer: e.answer) {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}
