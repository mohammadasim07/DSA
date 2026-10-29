class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSub = Integer.MAX_VALUE;
        int l = maxSub;
        int j = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum >= target) {
                while (j <= i && sum >= target) {
                    maxSub = (i - j + 1 < maxSub)
                            ? i - j + 1 : maxSub;

                    sum -= nums[j];
                    j++;
                }
            }
        }

        return (maxSub == l) ? 0 : maxSub;
    }
}