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
        String IOI = makeIOI();
        int IOILength = IOI.length();
        int idx = 0;
        int count = 0;
        while (idx + IOILength <= e.m) {
            if (e.s.substring(idx, idx + IOILength).equals(IOI)) {
                count++;
                idx += 2;
            } else {
                idx++;
            }
        }

        e.answer = count;
    }

    private String makeIOI() {
        return "IO".repeat(e.n) + "I";
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
