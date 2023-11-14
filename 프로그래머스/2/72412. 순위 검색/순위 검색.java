import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    static HashMap<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String s : info) {
            String[] arr = s.split(" ");
            makeSentence(arr, "", 0);
        } // info를 통해 검색될 수 있는 쿼리의 모든 경우를 map에 넣음

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        } // list 정렬

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" "); // 쿼리와 점수를 분리
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    public int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

    public void makeSentence(String[] arr, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(arr[4]));

            return;
        }

        makeSentence(arr, str + "-", cnt + 1);
        makeSentence(arr, str + arr[cnt], cnt + 1);
    }
}