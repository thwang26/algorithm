class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

		int i = 0;
		for(int n : numbers){
			answer[i] = 2*n;
			i++;
		}
        return answer;
    }
}