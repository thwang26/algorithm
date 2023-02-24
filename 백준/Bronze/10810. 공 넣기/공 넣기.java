import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] arr = new int[scan.nextInt()];

        int n = scan.nextInt();
        
        while(n!=0){
            int i = scan.nextInt();
            int j = scan.nextInt();
            int k = scan.nextInt();
            
            while(i<=j){
                arr[i-1] = k;
                i++;
            }
            n--;
        }
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}