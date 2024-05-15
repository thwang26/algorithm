import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] operation;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        operation = new int[4];
        for (int i = 0; i < operation.length; i++) {
            operation[i] = sc.nextInt();
        }

        recur(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recur(int idx, int currentResult) {
        if (idx == arr.length - 1) {
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }
        
        for (int i = 0; i < operation.length; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                recur(idx + 1, cal(currentResult, arr[idx + 1], i));
                operation[i]++;
            }
        }
    }
    
    private static int cal(int currentResult, int add, int operationNumber) {
        int newResult;

        if (operationNumber == 0) {
            newResult = currentResult + add;
        } else if (operationNumber == 1) {
            newResult = currentResult - add;
        } else if (operationNumber == 2) {
            newResult = currentResult * add;
        } else {
            boolean isMinus = currentResult < 0;
            if (isMinus) {
                newResult = -(-currentResult / add);
            } else {
                newResult = currentResult / add;
            }
        }

        return newResult;
    }
}
