import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Main main = new Main();
    Element e = new Element();
    static class Element {
        int N;
        int M;
        List<List<Coordinate>> list = new ArrayList<>();
        int answer;
        boolean[] visited;
    }

    static class Coordinate {
        int dest;
        int cost;

        public Coordinate(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        e.N = Integer.parseInt(st.nextToken());
        e.M = Integer.parseInt(st.nextToken());
        e.visited = new boolean[e.N];

        for (int i = 0; i <= e.N; i++) {
            e.list.add(new ArrayList<>());
        }

        for (int i = 0; i < e.M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            e.list.get(a - 1).add(new Coordinate(b, c));
            e.list.get(b - 1).add(new Coordinate(a, c));
        }
    }

    private void logic() {
        int[] answerArr = new int[e.N];
        Arrays.fill(answerArr, Integer.MAX_VALUE);
        answerArr[0] = 0;

        PriorityQueue<Coordinate> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.add(new Coordinate(1, 0));
        while (!pq.isEmpty()) {
            Coordinate coordinate = pq.poll();

            if (e.visited[coordinate.dest - 1]) {
                continue;
            }

            e.visited[coordinate.dest - 1] = true;
            answerArr[coordinate.dest - 1] =
                    Math.min(answerArr[coordinate.dest - 1],
                    coordinate.cost);
            for (Coordinate coo : e.list.get(coordinate.dest - 1)) {
                pq.add(new Coordinate(coo.dest, coordinate.cost + coo.cost));
            }
        }
        e.answer = answerArr[e.N - 1];
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
