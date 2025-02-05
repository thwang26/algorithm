import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(str);
            str = str.substring(1);
        }

        list.sort(null);
        list.forEach(System.out::println);
    }
}
