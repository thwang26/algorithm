import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        Integer[] arr = new Integer[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(arr[k-1]);
    }
}