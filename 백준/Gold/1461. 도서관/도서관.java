import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] books = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] minusBook = Arrays.stream(books).filter(each -> each < 0).toArray();
        int[] plusBook = Arrays.stream(books).filter(each -> each > 0).toArray();

        int totalMove = 0;
        Arrays.sort(minusBook);
        for (int i = 0; i < minusBook.length; i += m) {
            totalMove += -minusBook[i] * 2;
        }

        Arrays.sort(plusBook);
        for (int i = plusBook.length - 1; i >= 0; i -= m) {
            totalMove += plusBook[i] * 2;
        }

        int minusMax = minusBook.length > 0 ? -minusBook[0] : 0;
        int plusMax = plusBook.length > 0 ? plusBook[plusBook.length - 1] : 0;

        System.out.println(totalMove - Math.max(minusMax, plusMax));
    }
}
