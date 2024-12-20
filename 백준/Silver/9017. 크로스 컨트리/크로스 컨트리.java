import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Team> countMap = new HashMap<>();
            List<Integer> order = new ArrayList<>();
            while (n-- > 0) {
                int teamNumber = sc.nextInt();
                Team team = countMap.getOrDefault(teamNumber, new Team());
                team.count++;
                countMap.put(teamNumber, team);
                order.add(teamNumber);
            }

            List<Integer> winnerKey = countMap.keySet()
                    .stream()
                    .filter(key -> countMap.get(key).count == 6)
                    .collect(Collectors.toList());

            int orderValue = 0;
            for (Integer integer : order) {
                if (winnerKey.contains(integer)) {
                    Team team = countMap.get(integer);
                    team.score.add(++orderValue);
                }
            }

            winnerKey.sort((k1, k2) -> {
                Team o1 = countMap.get(k1);
                Team o2 = countMap.get(k2);
                if (o1.getFourSum() == o2.getFourSum()) {
                    return o1.getFive() - o2.getFive();
                }
                return o1.getFourSum() - o2.getFourSum();
            });

            System.out.println(winnerKey.get(0));
        }
    }

    static class Team {
        int count;
        List<Integer> score = new ArrayList<>();

        public int getFourSum() {
            return score.subList(0, 4).stream().mapToInt(Integer::intValue).sum();
        }

        public int getFive() {
            return score.get(4);
        }
    }
}