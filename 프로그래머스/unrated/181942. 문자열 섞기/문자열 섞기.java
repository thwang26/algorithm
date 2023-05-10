class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        for (int i = 0, j = 0; j < arr2.length; i++, j++){
            answer += Character.toString(arr1[i]) + Character.toString(arr2[j]);
        }
        return answer;
    }
}