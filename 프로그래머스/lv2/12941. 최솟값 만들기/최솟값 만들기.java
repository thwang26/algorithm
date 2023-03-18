import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = Integer.MAX_VALUE;
        int sumMin = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int j = 0 ; j < A.length ; j++){
            sumMin += A[j]*B[B.length-1-j];
        }
        answer = sumMin;
        return answer;
    }
}