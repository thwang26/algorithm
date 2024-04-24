import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Card[] card = new Card[n];
        for (int i = 0; i < card.length; i++) {
            card[i] = new Card(i, i);
        }

        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = sc.nextInt();
        }

        int[] shuffle = new int[n];
        for (int i = 0; i < shuffle.length; i++) {
            shuffle[i] = sc.nextInt();
        }

        int count = 0;
        while (!match(card, result)) {
            shuffle(card, shuffle);
            count++;

            if (first(card)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(count);
    }

    private static boolean match(Card[] card, int[] result) {
        return IntStream.range(0, card.length).allMatch(i -> card[i].order % 3 == result[i]);
    }

    private static void shuffle(Card[] card, int[] shuffle) {
        Arrays.stream(card).forEach(each -> each.order = shuffle[each.order]);
    }

    private static boolean first(Card[] card) {
        return IntStream.range(0, card.length).allMatch(i -> card[i].order == card[i].number);
    }

    static class Card {
        int number;
        int order;

        public Card(int number, int order) {
            this.number = number;
            this.order = order;
        }
    }
}