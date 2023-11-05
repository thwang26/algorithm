class Solution {
    public int solution(int n) {
        int answer;
        int i = n + 1;
        
        while (true) {
            String index = Integer.toBinaryString(i);
            String number = Integer.toBinaryString(n);
            if (getOneCount(index) == getOneCount(number)) {
                answer = i;
                break;
            }
            i++;
        }

        return answer;
    }

    public int getOneCount(String str) {
        int cnt = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }

        return cnt;
    }
}