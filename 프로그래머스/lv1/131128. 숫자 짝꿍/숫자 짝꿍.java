class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
		String answer;

		long[] xCount = new long[10];
		long[] yCount = new long[10];

		for(int i = 0 ; i < X.length() ; i++){
			xCount[X.charAt(i)-48]++;
		}

		for(int i = 0 ; i < Y.length() ; i++){
			yCount[Y.charAt(i)-48]++;
		}

		for(int i = 9 ; i >= 0 ; i--){
			long num = Math.min(xCount[i], yCount[i]);

			if(num == 0) continue;

			for(long j = 0 ; j < num ; j++){
				sb.append(i);
			}
		}
		answer = sb.toString();
		if(answer.length()==0) answer = "-1";
		else if(answer.charAt(0)=='0') answer = "0";
        return answer;
    }
}