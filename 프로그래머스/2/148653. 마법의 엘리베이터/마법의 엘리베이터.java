class Solution {
    public int solution(int storey) {
        int five = 5;
        int ten = 10;
        int count = 0;
        while (storey != 0) {
            int firstNumber = getFirstNumber(storey);
            storey = storey / 10;

            if (firstNumber > five) {
                count += (ten - firstNumber);
                storey++;
                continue;
            }
            if (firstNumber == five) {
                if (getFirstNumber(storey) >= five) {
                    count += (ten - firstNumber);
                    storey++;
                } else {
                    count += firstNumber;
                }
                continue;
            }
            count += firstNumber;
        }

        return count;
    }

    public int getFirstNumber(int number) {
        return number % 10;
    } // 1의 자리수 찾기
}