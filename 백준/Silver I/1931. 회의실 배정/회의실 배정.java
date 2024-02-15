import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) ->
        {
            if (o1.value.equals(o2.value)) {
                return o1.key - o2.key;
            }
            return o1.value - o2.value;
        });

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            pq.add(new Pair<>(startTime, endTime));
        }

        int count = 0;
        int beforeEndTime = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            if (beforeEndTime > pair.getKey()) {
                continue;
            }
            count++;
            beforeEndTime = pair.getValue();
        }

        System.out.println(count);
    }

    static class Pair<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            return null;
        }

    }
}
