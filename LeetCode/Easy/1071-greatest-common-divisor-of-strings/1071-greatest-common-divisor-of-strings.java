class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (canGcdOfStrings(str1, str2)) {
            return str1.substring(0, gcd(str1.length(), str2.length()));
        } else {
            return "";
        }
    }

    private boolean canGcdOfStrings(String str1, String str2) {
        return str1.concat(str2).equals(str2.concat(str1));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
