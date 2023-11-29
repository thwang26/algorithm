import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        String before = "before";
        for (String phone: phone_book) {
            if (phone.startsWith(before)) {
                return false;
            }
            before = phone;
        }

        return true;
    }
}