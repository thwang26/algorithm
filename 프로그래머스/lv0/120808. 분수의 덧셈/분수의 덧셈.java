class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		
		int numer3 = numer1*denom2+numer2*denom1;
		int denom3 = denom1*denom2;
		int n = 2;
		
		while(n<=denom3){
			if(numer3%n==0&&denom3%n==0){
				numer3 /= n;
				denom3 /= n;
			} else n++;
		}
		int[] answer = {numer3, denom3};

        return answer;
    }
}