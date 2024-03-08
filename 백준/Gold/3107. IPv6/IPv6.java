import java.util.Objects;
import java.util.Scanner;

public class Main {
    static final String DOUBLE_COLON = "::";
    static String[] result = new String[8];
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ip = sc.next();
        deleteDoubleColon(ip);
        addZero();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (i != result.length - 1) {
                sb.append(":");
            }
        }

        System.out.println(sb);
    }

    public static void deleteDoubleColon(String ip) {
        boolean containsDoubleColon = ip.contains(DOUBLE_COLON);

        String[] left = new String[0];
        String[] right = new String[0];
        if (containsDoubleColon) {
            if (ip.startsWith(DOUBLE_COLON)) {
                right = ip.substring(2).split(":");
            } else if (ip.endsWith(DOUBLE_COLON)) {
                left = ip.substring(0, ip.length() - 2).split(":");
            } else {
                int doubleColon = ip.indexOf(DOUBLE_COLON);
                left = ip.substring(0, doubleColon).split(":");
                right = ip.substring(doubleColon + 2).split(":");
            }

            parse(0, left);
            parse(8 - right.length, right);
        } else {
            result = ip.split(":");
        } // 포함 x
    }

    public static void parse(int idx, String[] arr) {
        int j = 0;
        for (int i = idx; i < idx + arr.length; i++) {
            result[i] = arr[j++];
        }
    }

    public static void addZero() {
        for (int i = 0; i < result.length; i++) {
            if (Objects.isNull(result[i])) {
                result[i] = "0".repeat(4);
                continue;
            }

            result[i] = "0".repeat(4 - result[i].length()) + result[i];
        }
    }
}
