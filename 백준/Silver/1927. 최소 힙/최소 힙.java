import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> pq =
                new PriorityQueue<>(Comparator.comparingLong(o -> o));

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            long number = Long.parseLong(br.readLine());
            if (number == 0) {
                bw.write(String.valueOf(pq.isEmpty() ? 0 : pq.poll()));
                bw.newLine();
            } else {
                pq.add(number);
            }
        }
        bw.flush();
        bw.close();
    }
}
