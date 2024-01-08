import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        List<Case> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
    }

    static class Case {
        List<Integer> aList;
        List<Integer> bList;

        public Case(List<Integer> aList, List<Integer> bList) {
            this.aList = aList;
            this.bList = bList;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer> aList = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            while (n-- > 0) {
                aList.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> bList = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            while (m-- > 0) {
                bList.add(Integer.parseInt(st.nextToken()));
            }

            aList.sort(Comparator.comparingInt(value -> value));
            bList.sort(Comparator.comparingInt(value -> value));

            e.list.add(new Case(aList, bList));
        }
        br.close();
    }

    private void logic() {
        for (Case c : e.list) {
            List<Integer> aList = c.aList;
            List<Integer> bList = c.bList;
            int answer = 0;
            for (int a : aList) {
                int smaller = findSmaller(bList, a);
                answer += smaller;
            }
            e.answer.add(answer);
        }
    }

    private int findSmaller(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        int n = 0;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (target > list.get(mid)) {
                left = mid;
            } else right = mid;
        }

        n += left;
        if (target > list.get(left)) {
            n++;
        }
        return n;
    }

    private void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : e.answer) {
            bw.write(String.valueOf(n));
            bw.newLine();
        }
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
