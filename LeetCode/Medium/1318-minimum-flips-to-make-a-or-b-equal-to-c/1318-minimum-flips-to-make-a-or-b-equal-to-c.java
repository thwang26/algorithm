public class Solution {
    public int minFlips(int a, int b, int c) {
        String aBinary = Integer.toBinaryString(a);
        String bBinary = Integer.toBinaryString(b);
        String cBinary = Integer.toBinaryString(c);
        int length = Math.max(aBinary.length(), Math.max(bBinary.length(), cBinary.length()));
        aBinary = "0".repeat(length - aBinary.length()).concat(aBinary);
        bBinary = "0".repeat(length - bBinary.length()).concat(bBinary);
        cBinary = "0".repeat(length - cBinary.length()).concat(cBinary);

        int flips = 0;
        for (int i = 0; i < length; i++) {
            boolean or = (aBinary.charAt(i) - '0' | bBinary.charAt(i) - '0') == 1;
            boolean and = (aBinary.charAt(i) - '0' & bBinary.charAt(i) - '0') == 1;
            if (cBinary.charAt(i) == '0') {
                if (and) {
                    flips += 2;
                } else if (or) {
                    flips++;
                }
            } else {
                if (!or) {
                    flips++;
                }
            }
        }

        return flips;
    }
}
