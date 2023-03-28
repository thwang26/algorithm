class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
		
		for(int i = 0 ; i < answer.length ; i++){
			answer[i] = -1;
		}//answer배열의 값을 -1로 초기화

		for(int i = 0 ; i < s.length() ; i++){

			for(int j = i-1 ; j >= 0 ; j--){

				if(s.charAt(i)==s.charAt(j)) {
					answer[i] = i-j;
					break;
				}//찾으면 해당글자의 인덱스와 찾은글자의 인덱스 값을 빼준 후 반복문 탈출

				if(j==0&&answer[i]==0) answer[i] = -1;//못 찾으면 -1

			}// 해당 글자와 앞글자 비교 반복
			
		}// 해당 글자 하나하나 반복

        return answer;
    }
}