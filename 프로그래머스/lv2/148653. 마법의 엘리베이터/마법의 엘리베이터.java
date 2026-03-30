class Solution {
    public int solution(int storey) {
        int count = 0;
        while (storey != 0) {
            int firstNumber = storey % 10;
            storey = storey / 10;
            int upperNumber = storey % 10;

            if (firstNumber > 5 || firstNumber == 5 && upperNumber >= 5) {
                count += (10 - firstNumber);
                storey++;
                continue;
            }
            count += firstNumber;
        }

        return count;
    }
}