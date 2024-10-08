import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Tanghulu tanghulu = new Tanghulu();
        for (int i = 0; i < n; i++) {
            tanghulu.add(sc.nextInt());
        }
        
        System.out.println(tanghulu.numberOfTanghulu);
    }

    static class Tanghulu {
        int numberOfTanghulu = 0;
        static int MAX_TANGHULU_COUNT = 2;
        List<Integer> tanghuluList = new ArrayList<>();
        int[] tanghuluCountArr = new int[10];

        public void add(int fruit) {
            tanghuluList.add(fruit);
            tanghuluCountArr[fruit]++;

            while (Arrays.stream(tanghuluCountArr).filter(i -> i > 0).count() > MAX_TANGHULU_COUNT) {
                int removedFruit = tanghuluList.remove(0);
                tanghuluCountArr[removedFruit]--;
            }

            numberOfTanghulu = Math.max(numberOfTanghulu, tanghuluList.size());
        }
    }
}
