import java.io.*;
import java.util.*;
import java.util.stream.Stream;

// 백준
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Map<String, String> map = new HashMap<>();

        for(int i = 0 ; i < nm[0] ; i++) {
            String[] str = br.readLine().split(" ");

            map.put(str[0], str[1]);
        }

        for(int i = 0 ; i < nm[1] ; i++){
            String find = br.readLine();
            bw.write(map.get(find)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }

}