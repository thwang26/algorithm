class Solution {
    public int solution(String t, String p) {
		Long longP = Long.parseLong(p); // p를 Long타입으로 형변환
		int pLength = p.length(); // p의 길이
        int answer = 0;

		for(int i = 0 ; i < t.length()-pLength+1 ; i++){//t에서 p의 크기만큼 반복
			if(i==t.length()-p.length()) {
				if(longP >= Long.parseLong(t.substring(i)))
					answer++; //마지막 글자
			}
			else if(longP >= Long.parseLong(t.substring(i, i+pLength)))
				answer++; //마지막 글자를 제외한 나머지 글자
		}

        return answer;
    }
}