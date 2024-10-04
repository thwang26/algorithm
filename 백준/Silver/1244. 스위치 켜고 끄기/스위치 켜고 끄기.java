import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSwitch = sc.nextInt();
        boolean[] switchArr = new boolean[numberOfSwitch + 1];
        for (int i = 1; i < switchArr.length; i++) {
            switchArr[i] = sc.nextInt() == 1;
        }

        int numberOfStudent = sc.nextInt();
        while (numberOfStudent-- > 0) {
            int male = sc.nextInt();
            int number = sc.nextInt();

            if (male == 1) {
                male(number, switchArr);
            } else {
                female(number, switchArr);
            }
        }

        for (int i = 1, j = 1; i < switchArr.length; i++, j = (j + 1) % 20) {
            System.out.printf("%d ", switchArr[i] ? 1 : 0);
            if (j == 0) {
                System.out.println();
            }
        }
    }

    private static void male(int number, boolean[] switchArr) {
        for (int i = number; i < switchArr.length; i += number) {
            switchArr[i] = !switchArr[i];
        }
    }

    private static void female(int number, boolean[] switchArr) {
        int leftIdx = number;
        int rightIdx = number;
        while (leftIdx - 1 >= 1 && rightIdx + 1 < switchArr.length
                && switchArr[leftIdx - 1] == switchArr[rightIdx + 1]) {
            leftIdx--;
            rightIdx++;
        }

        IntStream.rangeClosed(leftIdx, rightIdx).forEach(i -> switchArr[i] = !switchArr[i]);
    }
}
