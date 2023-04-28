import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        int answer = Integer.parseInt(scan.nextLine());

        Loop1:
        while(true) {
            str = scan.nextLine();
            switch(str) {
                case "+":   answer += Integer.parseInt(scan.nextLine());
                            break;
                case "-":   answer -= Integer.parseInt(scan.nextLine());
                            break;
                case "*":   answer *= Integer.parseInt(scan.nextLine());
                            break;
                case "/":   answer /= Integer.parseInt(scan.nextLine());
                            break;
                default: break Loop1;
            }
        }

        System.out.println(answer);
    }
}