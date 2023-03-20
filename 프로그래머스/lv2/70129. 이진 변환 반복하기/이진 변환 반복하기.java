class Solution {
    public int[] solution(String s) {
        StringBuilder binary = new StringBuilder();
        int cnt1 = 0;
        int cnt2 = 0;
        int i;
        while(!s.equals("1")){
            binary.setLength(0);
            i = 0;
            do {
                if(s.charAt(i)=='0'){
                    cnt2++;
                } else binary.append("1");
                i++;
            } while(i != s.length());
            s = Integer.toBinaryString(binary.length());
            cnt1++;
        }
        int[] answer = {cnt1, cnt2};
        return answer;
    }
}