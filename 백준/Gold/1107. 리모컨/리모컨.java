import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static Main main = new Main();
    Element e = new Element();

    static class Element {
        int channel;
        int m;
        Set<Integer> set = new HashSet<>();
        int count;
    }

    private void input() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        e.channel = Integer.parseInt(br.readLine());
        e.m = Integer.parseInt(br.readLine());
        e.set = IntStream.range(0, 10).boxed()
                .collect(Collectors.toSet());
        if (0 != e.m) {
            Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                    .forEach(e.set::remove);
        }
    }

    private void logic() {
        if (e.channel == 100) {
            return;
        } // 채널을 돌리지 않는경우
        e.count = Math.abs(e.channel - 100); // +/-로만 채널을 변경하는 경우
        if (!e.set.isEmpty()) {
            dfs(""); // 번호를 누르고 +/-로 변경하는 경우
        }
    }

    private void dfs(String makeChannel) {
        for (int n : e.set) {
            String currentChannel = makeChannel + n;
            e.count = Math.min(e.count,
                    Math.abs(e.channel - Integer.parseInt(currentChannel)) + currentChannel.length());

            if (currentChannel.length() < 6) {
                dfs(currentChannel);
            }
        }
    }

    private void output() {
        System.out.println(e.count);
    }

    public static void main(String[] args) throws IOException {
        main.input();
        main.logic();
        main.output();
    }
}