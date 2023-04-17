import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 백준
public class Main {
    static int cnt;
    static int[] arr2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void heapSort(int[] A, int n) {
        buildMinHeap(A, n);
        for (int i = n; i > 1; i--) {
            int temp = A[0];
            A[0] = A[i - 1];
            A[i - 1] = temp;
            cnt--;
            if (cnt == 0) {
                arr2 = A.clone();
                return;
            }
            heapify(A, 1, i - 1);
        }
    }

    public static void buildMinHeap(int[] A, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(A, i, n);
        }
    }

    public static void heapify(int[] A, int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller;
        if (right <= n) {
            if (A[left - 1] < A[right - 1]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }
        if (A[smaller - 1] < A[k - 1]) {
            int temp = A[k - 1];
            A[k - 1] = A[smaller - 1];
            A[smaller - 1] = temp;
            cnt--;
            if (cnt == 0) {
                arr2 = A.clone();
                return;
            }
            heapify(A, smaller, n);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String[] number = br.readLine().split(" ");

        int n = Integer.parseInt(number[0]);
        int k = Integer.parseInt(number[1]);

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        cnt = k;
        heapSort(arr, n);
        if (arr2 != null) {
            for (int num: arr2) {
                bw.write(num + " ");
            }
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}