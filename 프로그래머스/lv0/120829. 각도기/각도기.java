class Solution {
    public int solution(int angle) {
        int answer = 0;

		switch(angle/90){
			case 0 : answer = 1;
				break;
			case 1 : answer = angle % 90 == 0 ? 2 : 3;
				break;
			case 2 : answer = 4;
				break;
		}

        return answer;
    }
}