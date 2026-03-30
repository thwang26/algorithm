class Solution {
    public long solution(int r1, int r2) {
        return (getBigOne(r2) - getSmallOne(r1)) * 4;
    }

    public long getBigOne(int r) {
        long count = 0;
        for (int i = 0; i < r; i++) {
            count += (long)Math.sqrt(Math.pow(r, 2) - Math.pow(i, 2));
        }

        return count;
    }

    public long getSmallOne(int r) {
        long count = 0;
        for (int i = 0; i < r; i++) {
            double sqrt = Math.sqrt(Math.pow(r, 2) - Math.pow(i, 2));

            count += (long)sqrt;
            if (sqrt > 0 && sqrt == (double)(int)sqrt) {
                count--;
            }
        }
        return count;
    }
}