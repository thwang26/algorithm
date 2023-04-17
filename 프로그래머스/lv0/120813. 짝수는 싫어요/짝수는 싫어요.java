import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        int[] answer = IntStream.range(1, n+1).filter(x -> x % 2 != 0).toArray();
        return answer;
    }
}