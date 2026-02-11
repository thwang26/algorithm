import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x1 = 0;
        int x2 = Integer.MAX_VALUE;
        int y1 = 0;
        int y2 = Integer.MAX_VALUE;
        int z1 = 0;
        int z2 = Integer.MAX_VALUE;
        while (n-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            x1 = Math.max(x1, arr[0]);
            y1 = Math.max(y1, arr[1]);
            z1 = Math.max(z1, arr[2]);
            x2 = Math.min(x2, arr[3]);
            y2 = Math.min(y2, arr[4]);
            z2 = Math.min(z2, arr[5]);
        }

        int diffX = x2 - x1;
        int diffY = y2 - y1;
        int diffZ = z2 - z1;
        if (diffX <= 0 || diffY <= 0 || diffZ <= 0) {
            System.out.println(0);
            return;
        }
        System.out.println(diffX * diffY * diffZ);
    }
}