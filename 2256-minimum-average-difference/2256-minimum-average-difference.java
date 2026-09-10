class Solution {
    public int minimumAverageDifference(int[] nums) {
        long [] pre = new long[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        long minDiff = Integer.MAX_VALUE;
        int minindex = 0;
        for (int i = 0; i < nums.length; i++) {
            long left = pre[i] / (i + 1);
            long right = 0;
            if(i != nums.length - 1){
               right = (pre[nums.length - 1] - pre[i]) / (nums.length- i - 1); 
            }
           
        long absValue =  Math.abs(right - left);
            
           
            if (absValue < minDiff) {
               minDiff = absValue;
                minindex = i;
            }

        }

        return minindex;
    }
}