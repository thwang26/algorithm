import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dice dice = new Dice();
        dice.addBoard(sc.next());
        for (int i = 0; i < 3; i++) {
            dice.add(sc.nextInt());
        }

        dice.makeScore();
        System.out.println(dice.getMaxScore());
    }

    static class Dice {
        List<Boolean> diceBoard = new ArrayList<>(Collections.nCopies(12, false));
        List<Integer> dice = new ArrayList<>();
        int distinctSize;
        int sum;
        int maxScore = 0;

        public void add(int n) {
            dice.add(n);
        }

        public void addBoard(String str) {
            for (int i = 0; i < str.length(); i++) {
                diceBoard.set(i, str.charAt(i) == 'Y');
            }
        }

        public void makeScore() {
            init();
            numbers();
            fourOfAKind();
            fullHouse();
            littleStraight();
            bigStraight();
            yacht();
            choice();
        }

        public void init() {
            distinctSize = (int) dice.stream().distinct().count();
            sum = dice.stream().mapToInt(Integer::intValue).sum();
        }

        public void numbers() {
            for (int i = 0; i < 6; i++) {
                if (!diceBoard.get(i)) {
                    continue;
                }

                int currentDice = i + 1;
                int alreadyDiceCount = (int) dice.stream().filter(d -> d == currentDice).count();
                int currentScore = currentDice * (alreadyDiceCount + 2);

                maxScore = Math.max(maxScore, currentScore);
            }
        }

        public void fourOfAKind() {
            if (!diceBoard.get(6) || distinctSize > 2) {
                return;
            }

            int add = findDuplicate(dice) * 4;

            maxScore = Math.max(maxScore, add);
        }

        public void fullHouse() {
            if (!diceBoard.get(7) || distinctSize > 2) {
                return;
            }

            int add = 0;
            int big = 0;
            int small = 0;
            if (distinctSize == 1) {
                if (dice.get(0) == 6) {
                    big = 6;
                    small = 5;
                } else {
                    big = dice.get(0);
                    small = 6;
                }
            } else {
                big = dice.stream().max(Integer::compare).get();
                small = dice.stream().min(Integer::compare).get();
            }
            add = big * 3 + small * 2;

            maxScore = Math.max(maxScore, add);
        }

        public void littleStraight() {
            if (!diceBoard.get(8)) {
                return;
            }

            if (!dice.contains(6) && distinctSize == 3) {
                maxScore = Math.max(maxScore, 30);
            }
        }

        public void bigStraight() {
            if (!diceBoard.get(9)) {
                return;
            }

            if (!dice.contains(1) && distinctSize == 3) {
                maxScore = Math.max(maxScore, 30);
            }
        }

        public void yacht() {
            if (!diceBoard.get(10) || distinctSize != 1) {
                return;
            }

            maxScore = Math.max(maxScore, 50);
        }

        public void choice() {
            if (!diceBoard.get(11)) {
                return;
            }

            maxScore = Math.max(maxScore, sum + 12);
        }

        private int findDuplicate(List<Integer> list) {
            Set<Integer> seen = new HashSet<>();
            for (Integer number : list) {
                if (!seen.add(number)) {
                    return number;
                }
            }
            return 0;
        }

        public int getMaxScore() {
            return maxScore;
        }
    }
}