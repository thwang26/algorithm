import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> clothes = new ArrayList<>();
        int upHolder = 0;
        int downHolder = 0;
        int normalHolder = 0;
        while (n-- > 0) {
            int holder = sc.nextInt();
            clothes.add(holder);

            if (holder == 1) {
                upHolder++;
            } else if (holder == 2) {
                downHolder++;
            } else {
                normalHolder++;
            }
        }

        int up = sc.nextInt();
        int down = sc.nextInt();

        if (upHolder + normalHolder < up || downHolder + normalHolder < down) {
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES");
        }

        StringBuilder sb = new StringBuilder();
        for (int c : clothes) {
            if (c == 1) {
                sb.append("U");
                upHolder--;
                up--;
            } else if (c == 2) {
                sb.append("D");
                downHolder--;
                down--;
            } else {
                if (upHolder < up) {
                    sb.append("U");
                    up--;
                } else {
                    sb.append("D");
                    down--;
                }
                normalHolder--;
            }
        }

        System.out.println(sb);
    }
}
