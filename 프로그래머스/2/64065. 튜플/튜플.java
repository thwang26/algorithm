import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        s = s.replaceAll("},\\{", "}{");

        List<List<Integer>> doubleList = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                startIdx = i + 1;
                continue;
            }

            if (s.charAt(i) == '}') {
                endIdx = i;
                List<Integer> list = Arrays.stream(s.substring(startIdx, endIdx).split(","))
                        .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
                doubleList.add(list);
            }
        }

        doubleList.sort(Comparator.comparingInt(List::size));
        List<Integer> answer = new ArrayList<>();
        for (List<Integer> list2: doubleList) {
            for (int n: list2) {
                if (!answer.contains(n)) {
                    answer.add(n);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}