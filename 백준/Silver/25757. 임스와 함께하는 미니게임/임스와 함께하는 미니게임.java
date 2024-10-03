import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String gameType = sc.next();

        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            set.add(sc.next());
        }

        int play;
        if ("Y".equals(gameType)) {
            play = set.size();
        } else if ("F".equals(gameType)) {
            play = set.size() / 2;
        } else {
            play = set.size() / 3;
        }

        System.out.println(play);
    }
}
