import java.util.Arrays;
 
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;

        int j = 0;
        for(int i = people.length-1 ; i>=0 ; i--){
            if(people[i]+people[j]<=limit){
                answer++;
                j++;
            } else answer++;
            if(j>=i) break;
        }
        return answer;
    }
}