
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int distinct = 0;
            int[] freq = new int[nums.length + 1];

            for (int j = i; j < nums.length; j++) {

                if (freq[nums[j]] == 0) {
                    distinct++;
                }

                freq[nums[j]]++;

                if (distinct > k) {
                    break;
                }

                if (distinct == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
