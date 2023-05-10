class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        int idx = overwrite_string.length() + s;
        return my_string.substring(0, s)+overwrite_string+my_string.substring(idx);
    }
}