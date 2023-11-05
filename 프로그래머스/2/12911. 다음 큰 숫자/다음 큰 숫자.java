class Solution {
    public int solution(int n) {
        int answer;
        int i = n + 1;
        
        int number = getOneCount(Integer.toBinaryString(n));
        while (true) {
            String index = Integer.toBinaryString(i);
            if (getOneCount(index) == number) {
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