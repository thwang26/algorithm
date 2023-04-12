import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 백준
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList();

        for(int i = 0 ; i < M ; i++) {
            String[] str = br.readLine().split(" ");
            Integer num = 0;
            if (str.length == 2) {
                num = Integer.parseInt(str[1]);
            }

            if (str[0].equals("add") && !list.contains(num)) {
                list.add(num);
            } else if (str[0].equals("remove") && list.contains(num)) {
                list.remove(num);
            } else if (str[0].equals("check")) {
                if (list.contains(num)) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (str[0].equals("toggle")) {
                if (list.contains(num)) {
                    list.remove(num);
                } else {
                    list.add(num);
                }
            } else if (str[0].equals("all")) {
                list = IntStream.range(1, 21)
                        .boxed()
                        .collect(Collectors.toList());
            } else if (str[0].equals("empty")) {
                list.clear();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}