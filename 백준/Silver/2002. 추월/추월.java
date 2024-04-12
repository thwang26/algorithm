import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> in = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            in.add(sc.next());
        }

        List<String> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            out.add(sc.next());
        }

        int count = 0;
        for (int i = 0; i < in.size(); i++) {
            for (int j = out.indexOf(in.get(i)) + 1; j < out.size(); j++) {
                if (i > in.indexOf(out.get(j))) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
