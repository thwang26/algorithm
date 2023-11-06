class Solution {
    public int solution(int n, int k) {
        String number = Integer.toString(n, k);
        String[] arr = number.split("0");

        int count = 0;
        for (String num: arr) {
            if (num.isEmpty()) {
                continue;
            }

            if(isPrime(Long.parseLong(num))) {
                count++;
            }
        }

        return count;
    }

    public boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        
        long n = 2;
        while (n * n <= num) {
            if (num % n == 0) {
                return false;
            }
            n++;
        }
        return true;
    }
}
