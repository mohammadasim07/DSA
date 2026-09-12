class Solution {
    public int countSpecialIntegers(int[] nums) {
     int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            int i0 = i;
            int i1 = 0;
            int i2 = 0;
            int count = 1;
            for(int j = 0;j<n;j++){
                if(j == i)continue;

                if(nums[i] == nums[j] && count == 1){
                    count++;
                    i1 = j;
                }
                else if(nums[i] == nums[j] && count == 2){
                    i2 = j;
                    count++;
                }
                else if(nums[i] == nums[j] && count >= 3){
                    count++;
                }
            }
            if((i0 < i1 && i1 < i2) && ((i1 - i0) == (i2 - i1)) && count == 3){
                sum++;
            }
        }
        return sum;
    }   
    }
