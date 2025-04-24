class Solution {
    int[] alpha = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 12, 11, 10, 9, 8, 7, 6,
            5, 4, 3, 2, 1};

    public int solution(String name) {
        int totalMove = 0;
        for (char c : name.toCharArray()) {
            totalMove += alpha[c - 'A'];
        }

        int length = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int j = i + 1;
            while (j < name.length() && name.charAt(j) == 'A') {
                j++;
            }
            length = Math.min(length,
                    Math.min(2 * i + (name.length() - j),
                            2 * (name.length() - j) + i));
        }

        return totalMove + length;
    }
}
