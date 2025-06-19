import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String s : info) {
            String[] arr = s.split(" ");
            makeSentence(arr, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < answer.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            if (map.containsKey(q[0])) {
                answer[i] = binarySearch(map.get(q[0]), Integer.parseInt(q[1]));
            }

        }

        return answer;
    }

    private int binarySearch(List<Integer> list, int n) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return list.size() - left;
    }

    private void makeSentence(String[] arr, String str, int count) {
        if (count == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }

        makeSentence(arr, str + "-", count + 1);
        makeSentence(arr, str + arr[count], count + 1);
    }
}
