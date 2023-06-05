import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return n % 2 == 0 ? (int) IntStream.rangeClosed(1, n)
                .filter(num -> num % 2 == 0)
                .mapToDouble(num -> Math.pow(num, 2)).sum() :
                IntStream.rangeClosed(1, n).
                        filter(num -> num % 2 != 0).sum();
    }
}