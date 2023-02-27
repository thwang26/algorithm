import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pd = scan.next();

        for(int i = 0 ; i < pd.length()/2 ; i++){
            if(pd.charAt(i)!=pd.charAt(pd.length()-1-i)){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}