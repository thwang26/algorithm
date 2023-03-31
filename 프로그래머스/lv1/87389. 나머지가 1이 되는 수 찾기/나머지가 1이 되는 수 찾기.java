class Solution {
    public int solution(int n) {
        int answer = 0;

		int x = 0;
		do{
			x++;
		}while(n%x!=1);

		answer = x;

        return answer;
    }
}