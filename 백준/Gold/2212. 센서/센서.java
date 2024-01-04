import java.io.*;
import java.util.*;

public class Main { // 센서
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        int n;
        int k;
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        int answer;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        e.n = Integer.parseInt(br.readLine());
        e.k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < e.n; i++) {
            e.set.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    private void logic() {
        if (e.k > e.n) {
            e.answer = 0;
            return;
        }
        
        int before = 1_000_001;
        for (int n : e.set) {
            if (before != 1_000_001) {
                e.list.add(n - before);
            }
            before = n;
        }

        e.list.sort(Comparator.comparingInt(value -> value));
        int amount = 1;
        while (amount++ < e.k) {
            e.list.remove(e.list.size() - 1);
        }
        e.answer = e.list.stream().mapToInt(Integer::intValue).sum();
    }

    private void output() throws IOException {
        System.out.println(e.answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}
