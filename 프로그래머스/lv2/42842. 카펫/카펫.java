class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1 ; i <= brown ; i++){
            for(int j = 1; j <= yellow ; j++){
                if(i*j==yellow && (i+2)*(j+2)==brown+yellow){
                    answer[0]=i+2;
                    answer[1]=j+2;
                }
            }
        }
        return answer;
    }
}