import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Country {
        int num;
        int gold;
        int silver;
        int bronze;
        int realRank;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        
        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getBronze() {
            return bronze;
        }

        public boolean same(Country c) {
            return this.gold == c.gold
                    && this.silver == c.silver
                    && this.bronze == c.bronze;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Country> list = new ArrayList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        while (n-- > 0) {
            int num = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            list.add(new Country(num, gold, silver, bronze));
        }

        list.sort(Comparator.comparing(Country::getGold).reversed()
                .thenComparing(Comparator.comparing(Country::getSilver).reversed())
                .thenComparing(Comparator.comparing(Country::getBronze).reversed())
        );

        rateRank(list);

        for (Country country : list) {
            if (country.num == k) {
                System.out.println(country.realRank);
                return;
            }
        }

    }

    public static void rateRank(List<Country> country) {
        int realRank = 0;
        int stackRank = 1;
        Country before = null;

        for (Country c : country) {
            if (before != null && before.same(c)) {
                stackRank++;
            } else {
                realRank += stackRank;
                stackRank = 1;
            }

            c.realRank = realRank;
            before = c;
        }
    }
}
