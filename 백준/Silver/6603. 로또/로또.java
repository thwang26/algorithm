import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            recur(0, arr, "", 0);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void recur(int idx, int[] arr, String number, int count) throws IOException {
        if (count == 6) {
            print(number);
            return;
        }

        if (idx == arr.length) {
            return;
        }

        String newNumber = count != 0 ? number + " " + arr[idx] :
                number + arr[idx];
        recur(idx + 1, arr, newNumber, count + 1);
        recur(idx + 1, arr, number, count);
    }

    private static void print(String number) throws IOException {
        bw.write(number);
        bw.newLine();
    }
}