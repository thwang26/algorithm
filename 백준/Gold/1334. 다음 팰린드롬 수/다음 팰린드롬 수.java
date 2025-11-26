import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    make palindrome and up number
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String beforeStr = br.readLine();
        String afterStr = makePalindrome(beforeStr);
        while (isSameAndBigger(beforeStr, afterStr)) {
            afterStr = upNumber(afterStr);
        }
        System.out.println(afterStr);
    }

    /*
    up middle number
    if number is 9, make 0, and near 2 index countup
     */
    private static String upNumber(String afterStr) {
        char[] arr = afterStr.toCharArray();

        boolean isOdd = arr.length % 2 == 1;
        int left = isOdd ? arr.length / 2 : arr.length / 2 - 1;
        int right = arr.length / 2;
        boolean applied = false;
        while (isMiddleNumberNine(arr, left)) {
            arr[left--] = '0';
            arr[right++] = '0';
            if (left == -1) {
                char[] newArr = new char[arr.length + 1];
                newArr[0] = '1';
                for (int i = 1; i < newArr.length - 1; i++) {
                    newArr[i] = arr[i - 1];
                }
                newArr[newArr.length - 1] = '1';
                left = 0;
                applied = true;
                arr = newArr;
                break;
            }
        }
        if (applied) {
            return toString(arr);
        }
        if (left == right) {
            arr[left] = (char) (arr[left] + 1);
        } else {
            arr[left] = (char) (arr[left] + 1);
            arr[right] = (char) (arr[right] + 1);
        }

        return toString(arr);
    }

    /*
    return true if middle of index number is nine
     */
    private static boolean isMiddleNumberNine(char[] arr, int idx) {
        return arr[idx] == '9';
    }

    /*
    A is bigger than B, return true
    else return false
     */
    public static boolean isSameAndBigger(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        boolean flag = true;
        if (arrA.length < arrB.length) {
            return false;
        }
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > arrB[i]) {
                return true;
            }
            if (arrA[i] < arrB[i]) {
                return false;
            }
        }
        return flag;
    }

    /*
    make palindrome from current string
    just make same character each index
     */
    public static String makePalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            arr[s.length() - i - 1] = s.charAt(i);
        }
        return toString(arr);
    }

    private static String toString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}