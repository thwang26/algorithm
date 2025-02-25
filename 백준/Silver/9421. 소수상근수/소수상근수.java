import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] eratosthenes = new int[n + 1];
        for (int i = 2; i < eratosthenes.length; i++) {
            if (eratosthenes[i] == 1) {
                continue;
            }

            for (int j = 2 * i; j < eratosthenes.length; j += i) {
                eratosthenes[j] = 1;
            }
        }

        Set<Integer> history = new HashSet<>();
        for (int i = 2; i < eratosthenes.length; i++) {
            if (eratosthenes[i] == 0) {
                int num = i;
                Set<Integer> current = new HashSet<>();
                while (true) {
                    num = getSum(num);

                    if (current.contains(num)) {
                        break;
                    }

                    current.add(num);

                    if (history.contains(num) || num == 1) {
                        history.addAll(current);
                        bw.write(String.valueOf(i));
                        bw.write("\n");
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static int getSum(int num) {
        return Arrays.stream(String.valueOf(num)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .map(e -> e * e)
                .sum();
    }
}