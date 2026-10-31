class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] pre = new int[n];


        pre[0] = nums[0];

        for(int i = 1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }


        int sum = nums[0];
        int maxj = sum;
        int left = 0;
        map.put(nums[0],0);
        for(int i = 1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
              //  sum-=pre[index];
                if(index >= left){
                    sum -= pre[index] - (left > 0 ? pre[left - 1] : 0);
                    left = index + 1;
                }
            }
            map.put(nums[i],i);
            sum+=nums[i];
            maxj = (maxj < sum)?sum : maxj;

        }
        
        return maxj;
    }
}