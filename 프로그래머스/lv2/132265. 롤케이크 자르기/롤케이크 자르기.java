import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> pieceOne = new HashMap<>();
        Map<Integer, Integer> pieceTwo = new HashMap<>();

        for (int i: topping) {
            pieceTwo.put(i, pieceTwo.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        int idx = 0;
        while (idx < topping.length) {
            if (pieceOne.size() == pieceTwo.size()) {
                count++;
            }

            pieceOne.put(topping[idx], pieceOne.getOrDefault(topping[idx], 0) + 1);
            pieceTwo.put(topping[idx], pieceTwo.get(topping[idx]) - 1);

            if (pieceTwo.get(topping[idx]) == 0) {
                pieceTwo.remove(topping[idx]);
            }

            idx++;
        }

        return count;
    }
}