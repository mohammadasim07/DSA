class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
    //     Set<Integer> a = new TreeSet<>();
    //   for (int num : nums) {
    //          a.add(num);
    //         }
        return nums[nums.length-k];
    }
}