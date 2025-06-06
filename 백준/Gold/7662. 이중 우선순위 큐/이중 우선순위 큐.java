import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            SortedMultiSet sortedMultiSet = new SortedMultiSet();
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String token = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if ("I".equals(token)) {
                    sortedMultiSet.add(n);
                } else {
                    if (sortedMultiSet.isEmpty()) {
                        continue;
                    }
                    if (n == 1) {
                        sortedMultiSet.removeMax();
                    } else {
                        sortedMultiSet.removeMin();
                    }
                }
            }

            if (sortedMultiSet.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(sortedMultiSet.getLast())
                        .append(" ")
                        .append(sortedMultiSet.getFirst());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class SortedMultiSet {
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public void add(int n) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        public int removeMin() {
            int min = map.firstKey();
            removeOne(min);
            return min;
        }

        public int removeMax() {
            int max = map.lastKey();
            removeOne(max);
            return max;
        }

        private void removeOne(int key) {
            int count = map.get(key);
            if (count == 1) {
                map.remove(key);
            } else {
                map.put(key, count - 1);
            }
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public int getFirst() {
            return map.firstKey();
        }

        public int getLast() {
            return map.lastKey();
        }
    }
}
