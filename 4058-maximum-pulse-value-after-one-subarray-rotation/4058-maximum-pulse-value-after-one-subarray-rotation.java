class Solution {
    public long maxValue(int[] nums) {
        long [] p = new long[nums.length + 1];
        for(int i = 0;i<nums.length;i++){
            p[i+1] = p[i] + ((i%2 == 0) ? nums[i] : -nums[i]);
        }

        long ans = p[nums.length];
        long[] best = {0,Long.MIN_VALUE};
        for(int i = 2;i<=nums.length;i++){
            best[(i-2) % 2] = Math.max(best[(i-2) % 2], p[i-2]);

            ans = Math.max(ans,p[nums.length] + 2*(best[i%2] - p[i]));
        }
        return ans;
    }
}