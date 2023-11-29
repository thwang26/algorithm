class Solution {
    public String solution(int n, int t, int m, int p) {
        int currentNumber = 0;
        int order = 1;
        String currentString = "";
        String answer = "";

        while (answer.length() != t) {
            if (currentString.isEmpty()) {
                currentString = Integer.toString(currentNumber++, n).toUpperCase();
            }

            if (order != p) {
                currentString = currentString.substring(1);
                order = increaseOrder(order, m);
                continue;
            }
            answer += currentString.substring(0, 1);
            currentString = currentString.substring(1);
            order = increaseOrder(order, m);
        }

        return answer;
    }

    public int increaseOrder(int order, int m) {
        order++;
        if (order > m) {
            return 1;
        }
        return order;
    }
}