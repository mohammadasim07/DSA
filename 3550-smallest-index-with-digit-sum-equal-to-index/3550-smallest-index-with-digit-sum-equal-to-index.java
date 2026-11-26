class Solution {


    public int sum(int k){
        int s = 0;
        while(k > 0){
            s+=k%10;
            k/=10;
        }

        return s;
    }


    public int smallestIndex(int[] nums) {
        int index = -1;
        for(int i = 0;i<nums.length;i++){
            int k = sum(nums[i]);
            if(k == i){
                index = i;
                break;
            }
        }
        return index;
    }
}