import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Factory factory = new Factory();
        for (char c : str.toCharArray()) {
            factory.add(c);
        }

        System.out.println(factory.cut);
    }

    static class Factory {
        int cut = 0;
        int stick = 0;
        boolean beforeOpen = false;

        public Factory() {
        }

        public void add(char c) {
            if (c == '(') {
                stick++;
                beforeOpen = true;
            } else {
                stick--;

                if (beforeOpen) {
                    cut += stick;
                } else {
                    cut++;
                }
                beforeOpen = false;
            }
        }
    }
}
