import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> passwordList = new ArrayList<>();
    static List<String> alphabetList = new ArrayList<>();
    static int l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        int c = sc.nextInt();

        while (c-- > 0) {
            alphabetList.add(sc.next());
        }

        makePassword(new Password(), 0);
        passwordList.stream().sorted().forEach(System.out::println);
    }

    private static void makePassword(Password password, int idx) {
        if (canMake(password)) {
            make(password);
        }

        for (int i = idx; i < alphabetList.size(); i++) {
            password.add(alphabetList.get(i));
            makePassword(password, i + 1);
            password.remove(alphabetList.get(i));
        }
    }

    private static boolean canMake(Password password) {
        return password.currentList.size() == l && password.consonant >= 2 && password.vowel >= 1;
    }

    private static void make(Password password) {
        String p = password.currentList.stream().sorted().reduce("", (s1, s2) -> s1 + s2);
        passwordList.add(p);
    }

    static class Password {
        List<String> currentList = new ArrayList<>();
        int consonant;
        int vowel;

        public void add(String str) {
            if ("aeiou".contains(str)) {
                vowel++;
            } else {
                consonant++;
            }
            currentList.add(str);
        }

        public void remove(String str) {
            if ("aeiou".contains(str)) {
                vowel--;
            } else {
                consonant--;
            }
            currentList.remove(str);
        }
    }
}
