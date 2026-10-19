class Solution {
    public int splitArray(int[] nums, int k) {
        


        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = 1;
            int currentSum = 0;

            // Count required subarrays for this mid
            for (int num : nums) {
                if (currentSum + num > mid) {
                    count++;
                    currentSum = num;
                } else {
                    currentSum += num;
                }
            }

            if (count > k) {
               
                low = mid + 1;
            } else {
                
                high = mid;
            }
        }

        return low;
    }
}

