import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Number> a = new ArrayList<>();
        int idx = 0;
        while (n-- > 0) {
            a.add(new Number(Integer.parseInt(st.nextToken()), idx++));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Number> b = new ArrayList<>();
        idx = 0;
        while (m-- > 0) {
            b.add(new Number(Integer.parseInt(st.nextToken()), idx++));
        }

        a.sort((o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.idx - o2.idx;
            }
            return o2.value - o1.value;
        });

        b.sort((o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.idx - o2.idx;
            }
            return o2.value - o1.value;
        });

        int idxA = 0;
        int idxB = 0;
        int flagA = 0;
        int flagB = 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (idxA < a.size() && idxB < b.size()) {
            if (a.get(idxA).value > b.get(idxB).value) {
                idxA++;
            } else if (a.get(idxA).value < b.get(idxB).value) {
                idxB++;
            } else {
                if (a.get(idxA).idx < flagA) {
                    idxA++;
                } else if (b.get(idxB).idx < flagB) {
                    idxB++;
                } else {
                    count++;
                    sb.append(a.get(idxA).value).append(" ");
                    flagA = a.get(idxA).idx;
                    flagB = b.get(idxB).idx;
                    idxA++;
                    idxB++;
                }
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

    static class Number {
        int value;
        int idx;

        public Number(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}