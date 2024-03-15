import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Trie trie = new Trie(new HashMap<>());
        for (int i = 0; i < n; i++) {
            
            String current = sc.next();
            Trie currentTrie = trie;
            for (int j = 0; j < current.length(); j++) {
                char c = current.charAt(j);
                currentTrie.map.put(c, currentTrie.map.getOrDefault(c,
                        new Trie(new HashMap<>())));
                currentTrie = currentTrie.map.get(c);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String current = sc.next();
            Trie currentTrie = trie;
            boolean found = true;
            for (char c : current.toCharArray()) {
                currentTrie = currentTrie.map.get(c);
                
                if (currentTrie == null) {
                    found = false;
                    break;
                }
            }

            if (found) {
                count++;
            }
        }

        System.out.println(count);
    }

    static class Trie {
        Map<Character, Trie> map;

        public Trie(Map<Character, Trie> map) {
            this.map = map;
        }
    }
}
