import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] arr = Arrays.stream(priorities.clone())
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        // 중요도를 내림차순으로 정렬
        int i = 0; // 정렬배열의 인덱스
        int j = 0; // priorities의 인덱스
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for (int k = 0; k < priorities.length; k++) {
            if (priorities[k] > max) {
                max = priorities[k];
                j = k;
            }
        }//최댓값의 인덱스

        while (true) {
            if (arr[i] == priorities[j]) {
                i++;
                cnt++;
                if (location == j){
                    answer = cnt;
                    break;
                }
            }
            j = (j + 1) % priorities.length;
        } // priorities를 순회하면서 정렬배열의 중요도와 일치하면 cnt++
        return answer;
    }
}