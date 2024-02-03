import java.util.Scanner;

public class Main {
    static String roomNumber = "";
    static int money;
    static int[] number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
        }

        money = sc.nextInt();

        makeMoney(1, n);

        boolean isMade;
        do {
            isMade = makeMoney(0, n);
        } while (isMade && !roomNumber.equals("0"));

        for (int i = 0; i < roomNumber.length(); i++) {
            int currentNumber = roomNumber.charAt(i) - '0';
            int currentMoney = number[roomNumber.charAt(i) - '0'];

            for (int j = number.length - 1; j >= 0; j--) {
                if (currentNumber < j && money >= number[j] - currentMoney) {
                    roomNumber =
                            "" + roomNumber.substring(0, i) + j + roomNumber.substring(i + 1);
                    money -= number[j] - currentMoney;
                    break;
                }
            }
        }

        System.out.println(roomNumber);
    }

    static boolean makeMoney(int low, int high) {
        int minIdx = 0;
        int min = 51;
        boolean isMade = false;
        for (int i = low; i < high; i++) {
            if (min > number[i]) {
                min = number[i];
                minIdx = i;
            }
        }

        if (money >= number[minIdx]) {
            roomNumber += String.valueOf(minIdx);
            money -= number[minIdx];
            isMade = true;
        }

        return isMade;
    }

}
