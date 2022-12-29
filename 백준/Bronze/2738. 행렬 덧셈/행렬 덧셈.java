import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();

        int[][] arrA = new int[A][B];
        int[][] arrB = new int[A][B];

        for(int i = 0 ; i < A ; i++){
            for(int j = 0 ; j < B ; j++){
                arrA[i][j] = scan.nextInt();
            }
        }
        for(int i = 0 ; i < A ; i++){
            for(int j = 0 ; j < B ; j++){
                arrB[i][j] = scan.nextInt();
            }
        }
        for(int i = 0 ; i < A ; i++){
            for(int j = 0 ; j < B ; j++){
                System.out.print(arrA[i][j]+arrB[i][j]+" ");
            }
            System.out.println();
        }
    }
}