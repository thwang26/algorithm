import java.io.*;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        int n;
        int m;
        String s;
        int answer;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        e.n = Integer.parseInt(br.readLine());
        e.m = Integer.parseInt(br.readLine());
        e.s = br.readLine();
        br.close();
    }

    private void logic() {
        int idx = 0;
        int count = 0;
        while (idx <= e.m) {
            if (e.s.startsWith("IOI", idx)) {
                idx += 2;
                count++;
                if (count == e.n) {
                    e.answer++;
                    count--;
                }
            } else {
                idx++;
                count = 0;
            }
        }
    }

    private void output() {
        System.out.println(e.answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}