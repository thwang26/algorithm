import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
    static List<String> keySet;

    public static void main(String[] args) {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int n1 = romaToDecimal(str1, 0);
        int n2 = romaToDecimal(str2, 0);
        System.out.println(n1 + n2);
        System.out.println(decimalToRoma("", n1 + n2));
    }

    private static int romaToDecimal(String str, int num) {
        if (str.length() == 0) {
            return num;
        }

        int first = map.get(str.substring(0, 1));
        if (str.length() >= 2 && first < map.get(str.substring(1, 2))) {
            int second = map.get(str.substring(1, 2));
            return romaToDecimal(str.substring(2), num + second - first);
        } else {
            return romaToDecimal(str.substring(1), num + first);
        }
    }

    private static String decimalToRoma(String str, int num) {
        if (num == 0) {
            return str;
        }

        String currentKey = null;
        for (String key : keySet) {
            if (num / map.get(key) > 0) {
                currentKey = key;
                break;
            }
        }

        return decimalToRoma(str + currentKey, num - map.get(currentKey));
    }
}
