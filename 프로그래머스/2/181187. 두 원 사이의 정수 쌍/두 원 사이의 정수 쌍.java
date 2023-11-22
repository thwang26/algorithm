class Solution {
    public long solution(int r1, int r2) {
        int n = r2 + 1;

        return (getBigOne(n, r2) - getSmallOne(n, r1)) * 4;
    }

    public long getBigOne(int n, int r) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (long)Math.sqrt(Math.pow(r, 2) - Math.pow(i, 2));
        }

        return count;
    }

    public long getSmallOne(int n, int r) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            double sqrt = Math.sqrt(Math.pow(r, 2) - Math.pow(i, 2));

            count += (long) sqrt;
            if (sqrt > 0 && sqrt == (double) (int) sqrt) {
                count--;
            }
        }
        return count;
    }
}