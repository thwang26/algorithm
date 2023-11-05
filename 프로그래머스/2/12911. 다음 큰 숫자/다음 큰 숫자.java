class Solution {

    public int howOne(String str){
        int cnt = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i)=='1') cnt++;
        }
        return cnt;
    }

    public int solution(int n) {
        int answer = 0;

        int i = n+1;
        String index;
        String number;
        while(true){
            index = Integer.toBinaryString(i);
            number = Integer.toBinaryString(n);
            if(howOne(index)==howOne(number)){
                answer = i;
                break;
            }
            i++;
        }
        return answer;
    }
}