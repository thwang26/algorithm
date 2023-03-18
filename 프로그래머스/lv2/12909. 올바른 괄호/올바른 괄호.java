class Solution {
    boolean solution(String s) {
        int gual = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(gual==0&&s.charAt(i)==')') {
                gual = -1;
                break;
            }
            else if(s.charAt(i)=='(') gual++;
            else gual--;
        }

        if(gual==0) return true;
        else return false;
    }
}