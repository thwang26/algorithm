class Solution {
    public int[] solution(int brown, int yellow) {
        int b = 0;
        while (true) {
            int number = (int) (Math.pow(b, 2) - (2 + brown/2) * b + brown + yellow);
            if (number == 0) {
                break;
            }
            b++;
        }

        return new int[]{(brown + yellow) / b, b};
    }
}
// B + Y = ab
// Y = (a-2)(b-2)

// Y = ab - 2a - 2b + 4
// B = 2a + 2b - 4

// Y = (a-2)(b-2)
// B = 2a + 2b - 4

// a = B/2 - b + 2
// Y = (B/2 - b + 2 - 2)(b - 2)
// Y = (B/2 - b)(b - 2)
// Y = (B/2)b - B - b^2 -2b
// 0 = b^2 - (2+B/2)b + B + Y