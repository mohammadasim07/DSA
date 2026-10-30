class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxData = Integer.MIN_VALUE;
        int point = 0;
        int count = 0;
        if(k == nums.length){return nums.length;}
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
            }
            while(point <= i && count > k){
                if(nums[point] == 0){
                    count--;
                }
                point++;
            }
            maxData = maxData < (i - point+ 1 ) ? (i - point + 1) : maxData;
        }

        return maxData;
    }
}