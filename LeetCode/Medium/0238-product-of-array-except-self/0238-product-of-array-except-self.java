public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCount = 0;
        for (int each : nums) {
            if (each == 0) {
                zeroCount++;
                continue;
            }
            total *= each;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount == 1) {
                    nums[i] = total;
                }
                continue;
            }
            if (zeroCount > 0) {
                nums[i] = 0;
            } else {
                nums[i] = total / nums[i];
            }
        }
        System.gc();
        return nums;
    }
}
