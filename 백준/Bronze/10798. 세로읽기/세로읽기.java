import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char[][] arr = new char[5][15];
    
        for(int i = 0 ; i < 5 ; i++){
            String sc = scan.nextLine();
            for(int j = 0 ; j < sc.length() ; j++){
                arr[i][j] = sc.charAt(j);
            }
        }
        for(int j = 0 ; j < 15 ; j++){
            for(int i = 0 ; i < 5 ; i++){
                if(arr[i][j]==0) continue;
                System.out.print(arr[i][j]);
            }
        }
    }
}