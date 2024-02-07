import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        int low = 0;
        int high = house[house.length - 1];
        System.out.println(binarySearch(house, low, high, c));
    }

    static int binarySearch(int[] house, int low, int high, int c) {
        int maxDistance = 0;
        while(low <= high) {
            int count = 1;
            int mid = (low + high) / 2;

            int before = house[0];
            for (int i = 1; i < house.length; i++) {
                if (house[i] - before >= mid) {
                    count++;
                    before = house[i];
                }
            }

            if (count < c) {
                high = mid - 1;
            } else {
                maxDistance = Math.max(maxDistance, mid);
                low = mid + 1;
            }
        }
        return maxDistance;
    }
}
// 조합 또는 이분탐색
